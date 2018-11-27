package GA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Evolove {
	private List<Goods> goods = new ArrayList<Goods>();
	private int bagSize;
	private int length;
	private int groupSize = 400;
	private double newVoluem;
	private BST bst= new BST();
	private double corssRate = 0.7;
	private double variateRate = 0.1;
	private Queue<int[]> queue;

	
	public void readGoods() {
		try(BufferedReader in = new BufferedReader(new FileReader("goods1.csv"))){
			String limit = in.readLine();
			String[] fields = limit.split(",");
			bagSize =new Integer(fields[1]);
			String inputLine = null;
			while((inputLine=in.readLine())!=null) {
				String[] field = inputLine.split(",");
				int number =new Integer(field[0]);
				double volume = new Double(field[1]);
				double value = new Double(field[2]);
				goods.add(new Goods(number,volume,value));
				length +=1;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void newGeneration() {
		while(bst.size()<groupSize) {
			insert(getIndividualCode());
		}
	}
	
	public void insert(int[] in) {
		IndividualUnit ind = new IndividualUnit();
		ind.setBinaryCodes(in);
		ind.setSize(goods);
		if(ind.setSize(goods)>bagSize) {
			ind.setFitness();
		}else {
			ind.setFitness(goods);
		}
		bst.put(ind.getFitness(), in);
	}
	
	public int[] getIndividualCode() {
		int[] binaryCode = new int[length];
		for(int i=0;i<length;i++) {
			double j = Math.random();
			if(j<0.5||(newVoluem+goods.get(i).getVoluem())>bagSize)	binaryCode[i]=0;
			else {
				binaryCode[i]=1;
			}
		}
		return binaryCode;
		
	}
	
	public void WeedOut() {
		int reserve = (int)(groupSize/10);
		for(int i =bst.size(); i>reserve;i--) {
			bst.deleteMin();
		}
	}
	
	public void CrossAndVariate() {
		queue = (Queue<int[]>) bst.ints();
		for(int s = 0; s < groupSize/2;s++) {
			int[] first = queue.remove();
			int[] fir = new int[length];
			for(int i = 0; i < length;i++) {
				fir[i] = first[i];
			}
			int[] second = queue.remove();
			int[] sec = new int[length];
			for(int i = 0; i < length;i++) {
				sec[i] = second[i];
			}
			if(Math.random()<corssRate) {
				cross(fir,sec);
			}else {
				
			}
			if(Math.random()<variateRate) {
				queue.add(Variate(fir));
			}
			if(Math.random()<variateRate) {
				queue.add(Variate(sec));
			}
		}
		while(!queue.isEmpty()) {
			insert(queue.remove());
			bst.deleteMin();
		}
	}
	
	public void cross(int[] fir, int[] sec) {
		int l = length/5;
		int le = (int)(Math.random()*l+1);
		for(int i = (int)(Math.random()*length);le>0&&i<length;i++) {
			int x = fir[i];
			fir[i] = sec[i];
			sec[i] = x;
			le--;
		}
	}
	
	public int[] Variate(int[] in) {
			int i = (int)(Math.random()*length);
			if(in[i]==1) {
				in[i]=0;
			}else {
				in[i]=1;
			}
		return in;
	}
	
	public void start() {
		readGoods();
		for(int i = 0; i < 400;i++) {
			newGeneration();
			CrossAndVariate();
			WeedOut();
		}
		queue = (Queue<int[]>) bst.ints();
		while(!queue.isEmpty()) {
			IndividualUnit ind = new IndividualUnit();
			int[] max = queue.remove();
			ind.setBinaryCodes(max);
			for(int i=0;i<max.length;i++) {
				System.out.print(max[i]);
				if(i%5==4) {
					System.out.print(" ");
				}
			}
			System.out.println();
			System.out.println("TotalValue: "+ind.setFitness(goods));
		}
		
	}
	
}


