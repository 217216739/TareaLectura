import java.io.*;

public class LecturaTexto {
    public static void main(@org.jetbrains.annotations.NotNull String[] args) {
        if(args.length == 0){
            System.out.println("Falta el nombre del archivo");
            System.exit(1);
        }

        String fileName = args[0];

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("El nombre del archivo no se encuentra");
            System.exit(2);
        }

        BufferedReader in = new BufferedReader(fileReader);

        String textLine = null;
        int contador = 0;

        while (true) {
            try {
                if (!((textLine = in.readLine()) != null))
                    break;
            } catch (IOException e) {
                System.out.println("Error al leer el archivo");
                System.exit(3);
            }
            contador++;
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("El archivo " + fileName + " contiene " + contador + " líneas.");

    }
}
