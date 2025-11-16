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
    }

    public default void updateInputs(ArmIOInputs inputs) {}

    public default void moveToPosition(double position) {}
}