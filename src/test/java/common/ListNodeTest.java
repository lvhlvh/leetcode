package common;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class ListNodeTest {

  @Test
  public void testToString() {
    assertThat(Objects.requireNonNull(LinkedListUtil.newLinkedList(1, 2, 3)).toString())
        .isNotNull()
        .isEqualTo("1->2->3->null");
  }
}
