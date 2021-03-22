package matrixMethods.strategy;

import matrixReaders.castomExceptions.NonCompliaceException;
import matrixReaders.data.MatrixData;
import matrixReaders.data.interfaces.Matrixable;

public interface MatrixSolvableStrategy {
    Matrixable execute(MatrixData data) throws NonCompliaceException;
}
