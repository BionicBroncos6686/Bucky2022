package frc.robot;

public class Constants {
    public final static class Drivetrain {
        public final static int RIGHT_MASTER_PORT = 3;
        public final static int LEFT_MASTER_PORT = 1;
        public final static int RIGHT_FOLLOWER_PORT = 2;
        public final static int LEFT_FOLLOWER_PORT = 0;

        public final static double DRIVE_SPEED = 1;
        public final static double TURN_SPEED = 1;
    }

    public final static class Shooter {
        public final static int SHOOTER_PORT = 4;
        public final static double HIGH_SPEED_SHOOT = .75;
        public final static double LOW_SPEED_SHOOT = 0.6;
        public final static double AUTO_SHOOT = 0.6;
    }

    public static final class AutoConstants {
        public static final double kAutoDriveDistanceInches = 60;
        public static final double kAutoBackupDistanceInches = 20;
        public static final double kAutoDriveSpeed = .8;
    }
}
