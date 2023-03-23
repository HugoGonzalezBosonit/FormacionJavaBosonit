public class Person {
    // Atributos privados de la clase
    private String name;
    private String town;
    private int age;
    // Constructor Person
    public Person (String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }
    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTown() {
        return town;
    }
    public void setTown(String town) {
        this.town = town;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    // toString
    public String toString() {
        return "Person { " +
                "Name = '" + name + '\'' +
                ", Town = '" + town + '\'' +
                ", Age = " + age +
                " }";
    }
}
