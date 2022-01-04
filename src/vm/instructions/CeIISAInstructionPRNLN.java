package vm.instructions;

import vm.CeIVMAPIIOSubSys;
import vm.CeIVMAPIMemory;
import vm.CeIVMAPISpecialRegs;
import vm.exceptions.CeIVMMemoryException;
import vm.exceptions.CeIVMRuntimeException;
import java.util.ArrayList;

public class CeIISAInstructionPRNLN extends CeIISAInstruction {
   public CeIISAInstructionPRNLN(String mnemonic) {
      super(mnemonic);
   }

   public int getOpcode() {
      return 65;
   }

   public int getNumParameters() {
      return 0;
   }

   protected void execute(ArrayList<Integer> params, CeIVMAPIMemory mem, CeIVMAPISpecialRegs regs, CeIVMAPIIOSubSys io) throws CeIVMMemoryException, CeIVMRuntimeException {
      io.getOutputStream().println();
      regs.setPc(regs.getPc() + this.getInstructionSize());
   }
}
