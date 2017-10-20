package edu.homework08.exceptions.custom;

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
	 * @throws InvalidStudentDataException
	 */
	public Student(String name, String family, String sex, int age) throws InvalidStudentDataException {
		super();
		setName(name);
		setFamily(family);
		setSex(sex);
		setAge(age);
	}

	public Student() {
		super();
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
	 * @throws InvalidStudentDataException
	 */
	public void setSex(String sex) throws InvalidStudentDataException {
		if (sex != null) {
			if ("male".equalsIgnoreCase(sex)) {
				this.sex = sexType.MALE;
				return;
			} else if ("female".equalsIgnoreCase(sex)) {
				this.sex = sexType.FEMALE;
				return;
			}
		}
		throw new InvalidStudentDataException(" (sex type): " + sex);
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
	 * @throws InvalidStudentDataException
	 */
	public void setAge(int age) throws InvalidStudentDataException {
		if (age >= 7 && age <= 18) {
			this.age = age;
		} else {
			throw new InvalidStudentDataException(" (age): " + age);
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
	 * @throws InvalidStudentDataException
	 */
	public void setName(String name) throws InvalidStudentDataException {
		if (name != null && name.length() <= 12 && name.length() > 0) {
			this.name = name;
		} else {
			throw new InvalidStudentDataException(" (name): " + name);
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
	 * @throws InvalidStudentDataException
	 */
	public void setFamily(String family) throws InvalidStudentDataException {
		if (family != null && family.length() <= 20 && family.length() > 0) {
			this.family = family;
		} else {
			throw new InvalidStudentDataException(" (family): " + family);
		}
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, family=%s, sex=%s, age=%s]", name, family, sex, age);
	}

}
