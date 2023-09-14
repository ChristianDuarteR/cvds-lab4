/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.setup.guice;

/**
 *
 * @author 2106913
 */

import hangman.model.*;
import hangman.model.dictionary.HangmanDictionary;
import hangman.model.dictionary.FrenchDictionaryDataSource;
import hangman.view.HangmanNoviolentoPanel;
import hangman.view.HangmanPanel;

import com.google.inject.AbstractModule;

public class HangmanFactoryServices extends AbstractModule {

    @Override
    protected void configure() {
        /* Guice dependency injection */
        // bind(Interface.class).to(Concrete.class);
        // Binding para Language, usando French como implementación
        bind(Language.class).to(French.class);

        // Binding para HangmanDictionary, usando FrenchDictionaryDataSource como implementación
        bind(HangmanDictionary.class).to(FrenchDictionaryDataSource.class);

        // Binding para HangmanPanel, usando HangmanNoviolentoPanel como implementación
        bind(HangmanPanel.class).to(HangmanNoviolentoPanel.class);

        // Enlazar GameScore con OriginalScore para HangmanPanel
        bind(GameScore.class).to(OriginalScore.class);

        // Enlazar GameScore con PowerBonusScore para HangmanPanel
        //bind(GameScore.class).to(PowerBonusScore.class);

    }

}
