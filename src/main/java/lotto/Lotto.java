package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int findLottoNumber(int index) {
        return numbers.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(numbers.get(0));
        for (int lottoIndex = 1; lottoIndex < numbers.size(); lottoIndex++) {
            sb.append(", ");
            sb.append(numbers.get(lottoIndex));
        }
        sb.append("]");
        return sb.toString();
    }
}
