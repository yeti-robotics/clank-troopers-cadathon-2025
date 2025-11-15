package frc.robot.subsystems.hood;

import org.littletonrobotics.junction.AutoLog;

public interface HoodIO {
    @AutoLog
    public class HoodIOInputs {
        public double position = 0.0;
        public double targetPosition = 0.0;
    }

    public default void updateInputs(HoodIOInputs inputs) {}

    public default void moveToPosition(double position) {}
}
