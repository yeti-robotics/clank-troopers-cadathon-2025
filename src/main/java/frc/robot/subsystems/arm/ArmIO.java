package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.AutoLog;

public interface ArmIO {
    @AutoLog
    public class ArmIOInputs {
        public double positionDegCurrentMain = 0.0;
        public double positionDegTargetMain = 0.0;
        public double positionDegCurrentFollow = 0.0;
        public double positionDegTargetFollow = 0.0;
        public double velocityDegPerSec = 0.0;
        public double appliedVolts = 0.0;
        public double currentAmps = 0.0;
    }

    public default void updateInputs(ArmIOInputs inputs) {}

    public default void moveToPosition(double position) {}
}