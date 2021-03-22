package matrixReaders.readWriters.interfaces;

import matrixReaders.castomExceptions.NonCompliaceException;
import matrixReaders.data.MatrixData;
import matrixReaders.data.interfaces.Matrixable;

public interface MatrixRWable {
    MatrixData read() throws NonCompliaceException;
    int write(Matrixable matrix);
}
