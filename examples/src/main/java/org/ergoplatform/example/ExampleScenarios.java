package org.ergoplatform.example;

import org.ergoplatform.polyglot.*;

import java.util.Arrays;

/**
 * Examples demonstrating usage of blockchain client API.
 */
public class ExampleScenarios {

    private final BlockchainContext _ctx;

    /**
     * @param ctx blockchain context to be used to create the new transaction
     */
    public ExampleScenarios(BlockchainContext ctx) {
        _ctx = ctx;
    }

    /**
     * Example scenario creating and signing transaction that spends given boxes and aggregate
     * their ERGs into single new box protected with simple deadline based contract.
     *
     * @param seedPhrase secrete phrase used to generate secrets required to spend the boxes.
     * @param deadline   deadline (blockchain height) after which the newly created box can be spent
     * @param boxIds     string encoded (base16) ids of the boxes to be spent and agregated into the new box.
     */
    public SignedTransaction aggregateUtxoBoxes(String seedPhrase, int deadline, String... boxIds) {
        UnsignedTransactionBuilder txB = _ctx.newTxBuilder();
        InputBox[] boxes = _ctx.getBoxesById(boxIds);
        Long total = Arrays.stream(boxes).map(b -> b.getValue()).reduce(0L, (x, y) -> x + y);
        UnsignedTransaction tx = txB
                .boxesToSpend(boxes)
                .outputs(
                        txB.outBoxBuilder()
                                .value(total)
                                .contract(
                                    ErgoContract.create(
                                        ConstantsBuilder.create().item("deadline", deadline).build(),
                                        "{ HEIGHT > deadline }"))
                                .build())
                .build();

        ErgoProverBuilder proverB = _ctx.newProverBuilder();
        ErgoProver prover = proverB.withSeed(seedPhrase).build();
        SignedTransaction signed = prover.sign(tx);
        return signed;
    }

    /**
     * Example scenario which: 1) creates a mock box with the given script and
     * 2) use it as an input to a new transaction.
     * The new transaction is then signed using given seed phrase.
     *
     * @param mockTxId    string encoded id (base16) of a transaction which is used for the mock box.
     * @param outputIndex index of the mock box in the mock transaction
     * @param constants   named constants used in the script
     * @param ergoScript  source code of the script
     * @param seedPhrase  seed phrase to use for signature
     */
    public SignedTransaction prepareBox(
            String mockTxId, short outputIndex, Constants constants, String ergoScript,
            String seedPhrase) {
        UnsignedTransactionBuilder mockTxB = _ctx.newTxBuilder();
        OutBox out = mockTxB.outBoxBuilder()
                .contract(ErgoContract.create(constants, ergoScript))
                .build();
        UnsignedTransactionBuilder spendingTxB = _ctx.newTxBuilder();
        UnsignedTransaction tx = spendingTxB
                .boxesToSpend(out.convertToInputWith(mockTxId, outputIndex))
                .outputs(
                        spendingTxB.outBoxBuilder()
                                .contract(ErgoContract.create(ConstantsBuilder.empty(), "{ true }"))
                                .build())
                .build();
        ErgoProverBuilder proverB = _ctx.newProverBuilder();
        ErgoProver prover = proverB.withSeed(seedPhrase).build();
        SignedTransaction signed = prover.sign(tx);
        return signed;
    }
}