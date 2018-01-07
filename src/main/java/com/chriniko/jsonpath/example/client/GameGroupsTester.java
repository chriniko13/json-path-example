package com.chriniko.jsonpath.example.client;

import com.chriniko.jsonpath.example.service.GameGroupExtractor;
import org.springframework.context.ApplicationContext;

class GameGroupsTester {

    static void firstExample(ApplicationContext context) {

        GameGroupExtractor gameGroupExtractor = context.getBean("gameGroupExtractorImpl", GameGroupExtractor.class);

        testEuromillionsFamily(gameGroupExtractor);

        testLottoFamily(gameGroupExtractor);

        testLoexFamily(gameGroupExtractor);
    }

    private static void testEuromillionsFamily(GameGroupExtractor gameGroupExtractor) {
        //-------- first test for EuromillionsFamily EASY WAY ----------
        System.out.println("~~~EuromillionsFamily~~~");

        boolean isEuromillionsPrimaryGame = gameGroupExtractor.isPrimaryGame("EuromillionsFamily", "euromillions");
        System.out.println("isEuromillionsPrimaryGame = " + isEuromillionsPrimaryGame);

        boolean isSwisswinPrimaryGame = gameGroupExtractor.isPrimaryGame("EuromillionsFamily", "swisswin");
        System.out.println("isSwisswinPrimaryGame = " + isSwisswinPrimaryGame);

        boolean isRafflePrimaryGame = gameGroupExtractor.isPrimaryGame("EuromillionsFamily", "raffle");
        System.out.println("isRafflePrimaryGame = " + isRafflePrimaryGame);

        boolean isSuperstarPrimaryGame = gameGroupExtractor.isPrimaryGame("EuromillionsFamily", "superstar");
        System.out.println("isSuperstarPrimaryGame = " + isSuperstarPrimaryGame);

        System.out.println();


        //-------- first test for EuromillionsFamily HARD WAY ----------
        System.out.println("~~~EuromillionsFamily HARD~~~");

        isEuromillionsPrimaryGame = gameGroupExtractor.isPrimaryGame_Hard("EuromillionsFamily", "euromillions");
        System.out.println("isEuromillionsPrimaryGame = " + isEuromillionsPrimaryGame);

        isSwisswinPrimaryGame = gameGroupExtractor.isPrimaryGame_Hard("EuromillionsFamily", "swisswin");
        System.out.println("isSwisswinPrimaryGame = " + isSwisswinPrimaryGame);

        isRafflePrimaryGame = gameGroupExtractor.isPrimaryGame_Hard("EuromillionsFamily", "raffle");
        System.out.println("isRafflePrimaryGame = " + isRafflePrimaryGame);

        isSuperstarPrimaryGame = gameGroupExtractor.isPrimaryGame_Hard("EuromillionsFamily", "superstar");
        System.out.println("isSuperstarPrimaryGame = " + isSuperstarPrimaryGame);

        System.out.println();
    }

    private static void testLottoFamily(GameGroupExtractor gameGroupExtractor) {
        //-------- first test for LottoFamily EASY WAY ----------
        System.out.println("~~~LottoFamily~~~");

        boolean isSwisslottoPrimaryGame = gameGroupExtractor.isPrimaryGame("LottoFamily", "swisslotto");
        System.out.println("isSwisslottoPrimaryGame = " + isSwisslottoPrimaryGame);

        boolean isJokerPrimaryGame = gameGroupExtractor.isPrimaryGame("LottoFamily", "joker");
        System.out.println("isJokerPrimaryGame = " + isJokerPrimaryGame);

        boolean isReplayPrimaryGame = gameGroupExtractor.isPrimaryGame("LottoFamily", "replay");
        System.out.println("isReplayPrimaryGame = " + isReplayPrimaryGame);

        System.out.println();


        //-------- first test for LottoFamily HARD WAY ----------
        System.out.println("~~~LottoFamily HARD~~~");

        isSwisslottoPrimaryGame = gameGroupExtractor.isPrimaryGame_Hard("LottoFamily", "swisslotto");
        System.out.println("isSwisslottoPrimaryGame = " + isSwisslottoPrimaryGame);

        isJokerPrimaryGame = gameGroupExtractor.isPrimaryGame_Hard("LottoFamily", "joker");
        System.out.println("isJokerPrimaryGame = " + isJokerPrimaryGame);

        isReplayPrimaryGame = gameGroupExtractor.isPrimaryGame_Hard("LottoFamily", "replay");
        System.out.println("isReplayPrimaryGame = " + isReplayPrimaryGame);

        System.out.println();
    }

    private static void testLoexFamily(GameGroupExtractor gameGroupExtractor) {
        //-------- first test for LoexFamily EASY WAY ----------
        System.out.println("~~~LottoFamily~~~");

        boolean isLoroLottoExpressPrimaryGame = gameGroupExtractor.isPrimaryGame("LoexFamily", "lorolottoexpress");
        System.out.println("isLoroLottoExpressPrimaryGame = " + isLoroLottoExpressPrimaryGame);

        boolean isLoroLottoExpressExtraPrimaryGame = gameGroupExtractor.isPrimaryGame("LoexFamily", "lorolottoexpressextra");
        System.out.println("isLoroLottoExpressExtraPrimaryGame = " + isLoroLottoExpressExtraPrimaryGame);


        System.out.println();


        //-------- first test for LoexFamily HARD WAY ----------
        System.out.println("~~~LottoFamily HARD~~~");

        isLoroLottoExpressPrimaryGame = gameGroupExtractor.isPrimaryGame_Hard("LoexFamily", "lorolottoexpress");
        System.out.println("isLoroLottoExpressPrimaryGame = " + isLoroLottoExpressPrimaryGame);

        isLoroLottoExpressExtraPrimaryGame = gameGroupExtractor.isPrimaryGame_Hard("LoexFamily", "lorolottoexpressextra");
        System.out.println("isLoroLottoExpressExtraPrimaryGame = " + isLoroLottoExpressExtraPrimaryGame);


        System.out.println();
    }

}