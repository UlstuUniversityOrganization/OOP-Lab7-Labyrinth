import java.util.ArrayList;

public class BlocksRegister {
	static ArrayList<Block> registeredBlocks;
	
	public BlocksRegister(){
		registeredBlocks = new ArrayList<Block>();
		registeredBlocks.add(new BlockGrass());
		registeredBlocks.add(new BlockStone());
		registeredBlocks.add(new BlockLava());
		registeredBlocks.add(new BlockFinish());
		registeredBlocks.add(new BlockSpike());
	}
	
	public static Block getBlock(int id) {
		return registeredBlocks.get(id).clone();
	}
}
