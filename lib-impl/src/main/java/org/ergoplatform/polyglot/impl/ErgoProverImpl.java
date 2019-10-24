package org.ergoplatform.polyglot.impl;

import org.ergoplatform.ErgoBox;
import org.ergoplatform.ErgoLikeTransaction;
import org.ergoplatform.polyglot.ErgoProver;
import org.ergoplatform.polyglot.JavaHelpers;
import org.ergoplatform.polyglot.SignedTransaction;
import org.ergoplatform.polyglot.UnsignedTransaction;
import org.ergoplatform.wallet.interpreter.ErgoProvingInterpreter;
import scala.collection.IndexedSeq;

public class ErgoProverImpl implements ErgoProver {
  private final ErgoProvingInterpreter _prover;

  public ErgoProverImpl(ErgoProvingInterpreter prover) {
    _prover = prover;
  }

  @Override
  public SignedTransaction sign(UnsignedTransaction tx) {
    UnsignedTransactionImpl txImpl = (UnsignedTransactionImpl)tx;
    IndexedSeq<ErgoBox> boxesToSpend = JavaHelpers.toIndexedSeq(txImpl.getBoxesToSpend());
    IndexedSeq<ErgoBox> dataBoxes = JavaHelpers.toIndexedSeq(txImpl.getDataBoxes());
    ErgoLikeTransaction signed = _prover.sign(txImpl.getTx(), boxesToSpend, dataBoxes, txImpl.getStateContext()).get();
    return new SignedTransactionImpl(signed);
  }
}