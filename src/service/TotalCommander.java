package service;

import matrixMethods.MatrixSolver;
import matrixMethods.strategy.iterative.GausZeidelMethod;
import matrixReaders.castomExceptions.NonCompliaceException;
import matrixReaders.data.MatrixData;
import matrixReaders.data.interfaces.Matrixable;
import matrixReaders.factrories.MatrixRWFactory;
import matrixReaders.factrories.interfaces.ReaderFactory;
import matrixReaders.readWriters.interfaces.MatrixRWable;
import matrixReaders.statickClasses.UPCommunitation;

public class TotalCommander {

    public void readFromFile() {
        ReaderFactory matrixReaderFactory = new MatrixRWFactory();
        MatrixRWable matrixFileRW = matrixReaderFactory.createMatrixFileRW();

        try {
            MatrixData data = matrixFileRW.read();
            Matrixable result = gausZendelCount(data);

            UPCommunitation.printMatrix(result, data.getErrorValue());

        }catch (NonCompliaceException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void readFromConsole() {

        ReaderFactory matrixReaderFactory = new MatrixRWFactory();
        MatrixRWable matrixStdRW = matrixReaderFactory.createMatrixStdRW();
        try {
            MatrixData data = matrixStdRW.read();
            Matrixable result = gausZendelCount(data);

            UPCommunitation.printMatrix(result, data.getErrorValue() );

        }catch (NonCompliaceException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private Matrixable gausZendelCount(MatrixData matrixData) throws NonCompliaceException{
        MatrixSolver matrixSolver = new MatrixSolver();

        matrixSolver.setSolveStrategy(new GausZeidelMethod());

        Matrixable result = null;
        try {
            result = matrixSolver.executeStrategy(matrixData);
        }catch (NonCompliaceException ex) {
            throw new NonCompliaceException(ex.getMessage());
        }

        return result;
    }
}
