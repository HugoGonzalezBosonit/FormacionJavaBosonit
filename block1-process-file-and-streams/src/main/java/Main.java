import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    // Método que llama recibe una ruta y ejecuta el código de debajo que se encarga de filtrar el contenido de un archivo linea por linea
    // para añadir los substrings separados por : en la lista people
    public static List readPeopleFromFile(String peoplefile) throws IOException, InvalidLineFormatException {
        // Creo e inicializo la lista people
        ArrayList<Person> people = new ArrayList<>();
        // Abre el archivo utilizando la clase Files y uso un stream para procesar cada línea del archivo
        try (Stream<String> lines = Files.lines(Paths.get(peoplefile), StandardCharsets.UTF_8)) {
            lines.forEach(line -> {
                        // Divido el contenido de cada línea por el caracter :
                        String[] fields = line.split(":");
                        // Si la línea contiene menos de 1 campo o más de 3 se lanza la excepción InvalidLineFormationException
                        if (fields.length < 1 || fields.length > 3) {
                            try {
                                throw new InvalidLineFormatException(line, new IllegalArgumentException());
                            } catch (InvalidLineFormatException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        // Elimina los espacios iniciales y finales del nombre
                        String name = fields[0].trim();
                        // If que comprueva si el valor de la ciudad es mas largo de 1 y si no deja el campo vacío como ""
                        String town = fields.length > 1 ? fields[1].trim() : "";
                        // Si no existe el campo asignará el valor a 0 y si no eliminará los espacios y transforma el String en int
                        int age = fields.length > 2 ? Integer.parseInt(fields[2].trim()) : 0;

                        // Añado los campos divididos por : y personalizaados por las condiciones superiores en la List people
                        people.add(new Person(name, town, age));
                    }
            );
        }
        return people;
    }

    public static List<Person> ageFilter(List<Person> people) {
        List<Person> people2 = people.stream()
                .filter(p -> p.getAge() < 25 && p.getAge() > 0)
                .collect(Collectors.toList());
        for (Person p : people2) {
            if (p.getTown() == "") {
                p.setTown("unknown");
            }
        }
        return people2;
    }

    // Me borra unicamente 1 de los 2 que debería (sin el break surje un error)
    // USAR RECURSIVIDAD
    public static List<Person> nameFilter(List<Person> people) {
        for (Person people3 : people) {
            if (people3.getName().substring(0, 1).equals("A")) {
                people.remove(people3);

                nameFilter(people);

                break;
            }

        }

        return people;
    }

    public static Person townFilter1(List<Person> people) {
        Stream<Person> p4 = people.stream();
        Optional<Person> op = p4.filter(p -> p.getTown().equals("Madrid")).findFirst();
        return (op.isPresent()) ? op.get() : null;
    }

    public static Person townFilter2(List<Person> people) {
        Stream<Person> p5 = people.stream();
        Optional<Person> op = p5.filter(p -> p.getTown().equals("Barcelona")).findFirst();
        return (op.isPresent()) ? op.get() : null;
    }


    // Método main en el que pruevo todos los anteriores
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            // Archivo ejemplo ( Únicamente en mi caso y mi ordenador ) C:\Users\hugo.gonzalez\Desktop\peoplefile.txt
            List<Person> people = readPeopleFromFile(sc.next());

            for (Person p : people) System.out.println(p);

            System.out.println("--------------------------------------------------");

            for (Person p2 : ageFilter(people)) System.out.println(p2);

            System.out.println("--------------------------------------------------");

            for (Person p3 : nameFilter(people)) System.out.println(p3);

            System.out.println("--------------------------------------------------");

            System.out.println(townFilter1(ageFilter(people)));

            System.out.println("--------------------------------------------------");

            System.out.println(townFilter2(ageFilter(people)));

        } catch (IOException | InvalidLineFormatException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}