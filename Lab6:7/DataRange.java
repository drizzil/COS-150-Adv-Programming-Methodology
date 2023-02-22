public class DataRange {

	private float max;
	private float min;

	public DataRange() {
		this.max = Float.MIN_VALUE;
		this.min = Float.MAX_VALUE;
	}
	public DataRange update(float value) {
		this.max = Math.max(this.max, value);
		this.min = Math.min(this.min, value);
		return this;
	}
	public float getMax() {
		return max;
	}
	public void setMax(float max) {
		this.max = max;
	}
	public float getMin() {
		return min;
	}
	public void setMin(float min) {
		this.min = min;
	}
}