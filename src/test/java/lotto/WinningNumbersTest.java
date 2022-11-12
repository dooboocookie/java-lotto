package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {
    @Test
    void winningNumberInputTest() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers();
        Field winningNumbersField = WinningNumbers.class.getDeclaredField("winningNumbers");
        winningNumbersField.setAccessible(true);
        Lotto winningLotto = (Lotto) winningNumbersField.get(winningNumbers);

        Integer[] input = {1,2,3,4,5,6};
        winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input)));

        for (int index = 0; index < input.length; index++) {
            assertThat(winningLotto.findLottoNumber(index))
                    .isEqualTo(input[index]);
        }
    }

    @Test
    void winningNumberInputExceptionTest() throws Exception {
        WinningNumbers winningNumbers = new WinningNumbers();

        Integer[] input1 = {1,2,3,4,5,6,7};
        Integer[] input2 = {1,2,3,4,5};
        Integer[] input3 = {1,1,1,2,2,2};
        Integer[] input4 = {1,2,3,4,5,50};

        assertThatThrownBy(() ->
                winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input1))))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input2))))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input3))))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                winningNumbers.newWinningNumbers(new ArrayList<>(List.of(input4))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}