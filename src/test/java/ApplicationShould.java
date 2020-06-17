import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationShould {

    @Test
    void works() {
        Application a = new Application();
        assertThat(a.isTrue()).isTrue();
    }
}