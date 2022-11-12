package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Lotto> userLottos;
    private GameMoney gameMoney;

    public User() {}

    public void payMoney() {
        int money = Input.readInteger();
        this.gameMoney = new GameMoney(money);
    }

    public void buyLotto() {
        userLottos = new ArrayList<>();
        int numberOfPurchases = gameMoney.numberOfPurchases();
        for (int lottoCount = 0; lottoCount < numberOfPurchases; lottoCount++) {
            Lotto newLotto = LottoGenerator.generatorLotto();
            userLottos.add(newLotto);
        }
    }

    public int getLottoCount() {
        return userLottos.size();
    }

    public Lotto findLotto(int index) {
        return userLottos.get(index);
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }
}
