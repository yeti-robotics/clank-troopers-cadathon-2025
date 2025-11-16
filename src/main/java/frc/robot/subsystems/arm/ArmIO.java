package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {
    @AutoLog
    public class ArmIOInputs {
        public double positionDegCurrent = 0.0;
        public double positionDegTarget = 0.0;
        public double velocityDegPerSec = 0.0;
        public double appliedVolts = 0.0;
        public double currentAmps = 0.0;

        // for target position and current position, 0 is within bumper and 1 is read to intake
        public int targetPosition = 0;
        public int currentPosition = 1;
    }

    public default void updateInputs(ArmIOInputs inputs) {}

    public default void setPower(double power) {}
}