package batchoperation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {

	
	@Id
	@Column(name="itemno")
	private int Itemno;

	public int getItemno() {
		return Itemno;
	}

	public void setItemno(int itemno) {
		Itemno = itemno;
	}
	
	
	
	
	
}
