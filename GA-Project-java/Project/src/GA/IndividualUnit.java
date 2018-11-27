package GA;

import java.util.List;

public class IndividualUnit {
	private static int[] binaryCodes;//key
	private double fitness;//value
	private double size=100000;
	
	public int[] getBinaryCodes() {
		return binaryCodes;
	}
	public void setBinaryCodes(int[] binaryCodes) {
		this.binaryCodes = binaryCodes;
	}
	
	public double setSize(List<Goods> goods) {
		size = 0;
		int i = 0;
		for(Goods g:goods) {
			if(binaryCodes[i]==1)	size+=g.getVoluem();
			i+=1;
		}
		return size;
	}
	
	
	public double getSize() {
		return size;
	}
	
	public double setFitness() {
		fitness = 0;
		return 0;
	}
	
	//to be determined
	public double setFitness(List<Goods> goods) {
		fitness = 0;
		int i = 0;
		for(Goods g:goods) {
			if(binaryCodes[i]==1)	fitness+=g.getValue();
//			fitness= fitness+ g.getValue()/g.getVoluem()*2;
			i+=1;
		}
		return fitness;
	}
	
	public double getFitness() {
		return fitness;
	}
	
}
