package frc.robot.subsystems.shooter;

import frc.robot.subsystems.intake.IntakeIO;

public interface ShooterIO {
    public class ShooterIOInputs {
        public double feedSpeed = 0.0;
        public double flywheelSpeed = 0.0;
    }

    public default void updateInputs(ShooterIO.ShooterIOInputs inputs) {}

    public default void setFeedSpeed(double feedSpeed) {}
    public default void setFlywheels(double flySpeed) {}


}
