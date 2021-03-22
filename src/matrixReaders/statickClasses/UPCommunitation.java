package matrixReaders.statickClasses;

import matrixReaders.castomExceptions.NonCompliaceException;
import matrixReaders.data.interfaces.Matrixable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Predicate;

public abstract class UPCommunitation {
    public static String askForString(Predicate<String> request, String message, Scanner scanner) {
        String line = null;
        do {
            try {
                System.out.print(message);
                System.out.print(":");
                line = scanner.nextLine();
                line = line.trim();
                if (!request.test(line)) {
                    throw new NonCompliaceException("\nВведенные данные не соответствуют шаблону.");
                }
            }catch (NonCompliaceException ex) {
                System.err.println(ex.getMessage());
            }
        }while (!request.test(line));
        return line;
    }

    public static void printMatrix(Matrixable matrix, double approx) {
        int sizeI = matrix.sizeI();
        ArrayList<ArrayList<Double>> tmpMatrix = matrix.getArrayMatrix();
        Iterator<ArrayList<Double>> iter = tmpMatrix.iterator();

        int i = -1;

        int tmpSize = tmpMatrix.get(tmpMatrix.size() - 1).size();
        String lastVal = String.valueOf(tmpMatrix.get(tmpMatrix.size() - 1).get(tmpSize - 1));



//        int charID = lastVal.indexOf('.') + 1;
        int charID;
        if(approx == 0) charID = 1;
        else  charID = String.valueOf(approx).length() - 1;

//        try {
//            while (lastVal.charAt(charID) == '0') {
//                charID++;
//            }
//        }catch (IndexOutOfBoundsException ex) {/*NOPE*/}
//
//        charID--;

        Double tmpValue;
        Double scale = Math.pow(10, charID);


        while (iter.hasNext()) {

            ArrayList<Double> tmpRow = iter.next();
            i++;
            String stringRow = String.valueOf(i);
            stringRow = stringRow.concat("|");

            for (int j = 0; j < sizeI; j++) {
                tmpValue = Math.ceil(tmpRow.get(j) * scale) / scale;
                stringRow = stringRow.concat(String.valueOf(tmpValue));
                stringRow = stringRow.concat("|");
            }
            System.out.println(stringRow);
        }
        System.out.println();
    }
}
