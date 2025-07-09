package api.payload;

public class Store {
	long id;
	long petId;
	int quantity;
	String shipDate;
	Status status;
	boolean complete;

	public enum Status {
		PLACED, APPROVED, DELIVERED
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
}
