package GA;

public class Goods {//ŒÔ∆∑¿‡
	private int number;
	private double voluem;
	private double value;
	
	public Goods(int number,double voluem, double value) {
		setNumber(number);
		setVoluem(voluem);
		setValue(value);
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public double getVoluem() {
		return voluem;
	}
	public void setVoluem(double voluem) {
		this.voluem = voluem;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	public String toString() {
		return(getNumber()+" "+getVoluem()+" "+getVoluem());
	}
}
