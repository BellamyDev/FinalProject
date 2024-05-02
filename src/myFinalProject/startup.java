package myFinalProject;

import basicgraphics.BasicFrame;

public class startup {
        private static BasicFrame bf = new BasicFrame("Game");
        public static LoadingScreen loadingScreen = new LoadingScreen(bf);
        public static BasicFrame getBasicFrame() {
            return bf;
        }

    public static void start(){
        mainMenu.menu();
    }


}