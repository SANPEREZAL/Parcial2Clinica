package persistencia;

import model.Clinica;
import model.IPersistencia;

import java.io.*;

public class PersistenciaArchivo implements IPersistencia {

    private static final String ARCHIVO = "clinica.dat";

    @Override
    public void guardarClinica(Clinica clinica) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(clinica);
        }
    }

    @Override
    public Clinica cargarClinica() throws IOException, ClassNotFoundException {
        File file = new File(ARCHIVO);
        if (!file.exists()) {

            return new Clinica();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (Clinica) ois.readObject();
        }
    }
}
