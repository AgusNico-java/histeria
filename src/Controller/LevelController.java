package Controller;

import Model.LevelModel;
import enums.Difficulty;

public class LevelController {
    private LevelModel levelModel;

    public LevelController(LevelModel levelModel){
        this.levelModel = levelModel;
    }

    public void establecerDificultad(String dificultad) {
        levelModel.establecerDificultad(Difficulty.valueOf(dificultad));
    }
}
