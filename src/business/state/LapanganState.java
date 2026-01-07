package business.state;

import business.Lapangan;
import java.io.Serializable;

public interface LapanganState extends Serializable {
    void handle(Lapangan lapangan);
    String getStatus();
}