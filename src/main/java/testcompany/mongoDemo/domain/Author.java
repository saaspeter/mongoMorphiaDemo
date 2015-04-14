package testcompany.mongoDemo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

@Entity
public class Author {

	/** pk **/
	@Id private ObjectId objectId;
	
	@Indexed(name="Idx_name")
	private String name;
	private Integer age;
	private String status;
	
	private List<Address> addressList;
	
//	private List<Blog> authors;
	
	// must declare inner class as static, or morphia will throw exception
	@Embedded
	public static class Address implements Serializable{
		private String street;
		private String city;
		private String zip;
		
		// must have this constructor, morphia will use it
		public Address(){}
		
		public Address(String street, String city, String zip) {
			super();
			this.street = street;
			this.city = city;
			this.zip = zip;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
	public void addAddress(String street, String city, String zip){
		Address vo = new Address(street, city, zip);
		if(addressList==null){
			addressList = new ArrayList<Address>();
		}
		addressList.add(vo);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("{name:"+name+",age:"+age+",status:"+status+",");
		if(addressList!=null){
			buffer.append("[");
			int i = 0;
			for(Address address : addressList){
				i++;
				buffer.append("{street:").append(address.getStreet())
				      .append(",city:"+address.getCity())
				      .append(",zip:"+address.getZip())
				      .append("}");
				if(i<addressList.size()-1){
					buffer.append(",");
				}
			}
			buffer.append("]");
		}
		buffer.append("}");
		return buffer.toString();
	}
	
}
