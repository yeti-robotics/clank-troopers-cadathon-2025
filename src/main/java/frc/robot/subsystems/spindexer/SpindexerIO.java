package frc.robot.subsystems.spindexer;

import org.littletonrobotics.junction.AutoLog;

public interface SpindexerIO {
    @AutoLog
    public class SpindexerIOInputs {
        public double spinVelocity = 0.0;
    }

    public default void updateInputs(SpindexerIOInputs inputs) {}

    public default void setPower(double power) {}
}
