package edu.homework08.exceptions;

public class Student {
	static enum sexType {
		MALE, FEMALE
	};


	private String name;
	private String family;
	private sexType sex;
	private int age;

	/**
	 * @param name
	 * @param family
	 * @param sex
	 * @param age
	 */
	public Student(String name, String family, String sex, int age) {
		super();
		setName(name);
		setFamily(family);
		setSex(sex);
		setAge(age);
	}

	/**
	 * @return the sex
	 */
	public sexType getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		if (sex != null) {
			if ("male".equalsIgnoreCase(sex)) {
				this.sex = sexType.MALE;
				return;
			} else if ("female".equalsIgnoreCase(sex)) {
				this.sex = sexType.FEMALE;
				return;
			}
		} else {
			throw new IllegalArgumentException("Invalid sex type: " + sex);
		}
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		if (age >= 7 && age <= 18) {
			this.age = age;
		} else {
			throw new IllegalArgumentException("Invalid age: " + age);
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		if (name != null && name.length() <= 12 && name.length() > 0) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Invalid name: " + name);
		}
	}

	/**
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * @param family
	 *            the family to set
	 */
	public void setFamily(String family) {
		if (family != null && family.length() <= 20 && family.length() > 0) {
			this.family = family;
		} else {
			throw new IllegalArgumentException("Invalid family: " + family);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Student [name=%s, family=%s, sex=%s, age=%s]", name, family, sex, age);
	}

}
