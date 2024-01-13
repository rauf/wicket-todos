package in.rauf.models;

import java.io.Serializable;

public record User(Long id, String name, String email) implements Serializable {
}
