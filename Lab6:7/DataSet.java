public class DataSet {

	private int count;
	private float value;

	public DataSet(int count, float value) {
		this.count = count;
		this.value = value;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public DataSet updateValue(float value) {
		return new DataSet(count+1, this.value + value);
	}
}