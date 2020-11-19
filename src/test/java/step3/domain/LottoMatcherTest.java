package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class LottoMatcherTest {

    @DisplayName("인스턴스가 잘 생성되는지 확인한다.")
    @ParameterizedTest
    @MethodSource("createLottoMatcher")
    void createInstance(Lottos lottos, LastWeekLotto lastWeekLotto) {
        //given
        LottoMatcher lottoMatcher = LottoMatcher.ofMatch(lottos, lastWeekLotto);

        //then
        assertThat(lottoMatcher).isEqualTo(LottoMatcher.ofMatch(lottos, lastWeekLotto));
    }

    private static Stream<Arguments> createLottoMatcher() {
        return Stream.of(
                Arguments.of(
                        new Lottos(Collections.singletonList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7))),
                Arguments.of(
                        new Lottos(Collections.singletonList(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)), new LottoNumber(7))),
                Arguments.of(
                        new Lottos(Collections.singletonList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(21, 22, 23, 24, 25, 26)), new LottoNumber(7)))
        );
    }

    @DisplayName("로또 매칭할때 맞는 갯수만큼 돈이 잘 합산되는지 확인을 한다.")
    @ParameterizedTest
    @MethodSource("createLottoMatcherRank")
    void sumLottoMatchPrize(Lottos lottos, LastWeekLotto lastWeekLotto, GameMoney gameMoney) {
        //given
        LottoMatcher lottoMatcher = LottoMatcher.ofMatch(lottos, lastWeekLotto);
        //when
        GameMoney gamePrize = lottoMatcher.getGamePrize();
        //then
        assertThat(gamePrize).isEqualTo(gameMoney);
    }

    private static Stream<Arguments> createLottoMatcherRank() {
        return Stream.of(
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(45)), new GameMoney(LottoRank.FIRST.getPrice())),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), new LottoNumber(6)), new GameMoney(LottoRank.SECOND.getPrice())),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), new LottoNumber(45)), new GameMoney(LottoRank.THIRD.getPrice())),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)), new LottoNumber(45)), new GameMoney(LottoRank.FORTH.getPrice())),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)), new LottoNumber(45)), new GameMoney(LottoRank.FIFTH.getPrice())),
                Arguments.of(new Lottos(Collections.singletonList(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))),
                        LastWeekLotto.of(new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)), new LottoNumber(45)), new GameMoney(LottoRank.MISS.getPrice())));
    }


}