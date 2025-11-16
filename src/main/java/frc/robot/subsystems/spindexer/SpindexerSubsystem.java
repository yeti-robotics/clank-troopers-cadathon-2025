package frc.robot.subsystems.spindexer;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class SpindexerSubsystem extends SubsystemBase {
    private SpindexerIO io;
    private SpindexerIOInputsAutoLogged inputs = new SpindexerIOInputsAutoLogged();

    public SpindexerSubsystem(SpindexerIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Scoring Mechanism", inputs);
    }

    public Command spin(double power) {
        return run(() -> io.setPower(power));
    }

    public Command stop() {
        return run(() -> io.setPower(0));
    }
}
