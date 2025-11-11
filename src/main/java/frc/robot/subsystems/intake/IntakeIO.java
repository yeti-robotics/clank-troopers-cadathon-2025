package frc.robot.subsystems.intake;
import org.littletonrobotics.junction.AutoLog;

public interface IntakeIO {
    @AutoLog
    public class IntakeIOInputs {
        public double rollerPower = 0.0;

    }

    public default void updateInputs(IntakeIOInputs inputs) {}

    public default void setPower(double power) {}
}
