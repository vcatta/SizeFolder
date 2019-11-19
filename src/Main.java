import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main
{
    private static long sizeOfFolder;
    private static File folder = new File("C:/Users/v.namochilina/desktop/fotki");

    public static void main(String[] args) {

        try {
            sizeOfFolder = Files.walk(Paths.get(folder.getPath()))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .mapToLong(File::length)
                    .sum();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        displayChoice(sizeOfFolder);

    }

    private static void displayChoice(long sizeOfFolder)
    {
        int unit = 1024;
        int extent = (int)(Math.log(sizeOfFolder) / Math.log(unit));
        String pre = "KMGTPE";

        System.out.printf("Размер папки " + folder + (extent < 1 ? sizeOfFolder + " байт" : " %.2f " +
                pre.charAt(extent - 1) + "B"), sizeOfFolder / Math.pow(unit, extent));


    }

}
