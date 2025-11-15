package frc.robot.subsystems.hood;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HoodSubsystem extends SubsystemBase {

    private HoodIO io;
    private HoodIOInputsAutoLogged inputs = new HoodIOInputsAutoLogged();

    @Override
    public void periodic() {
        io.updateInputs(inputs);
    }

    public HoodSubsystem(HoodIO io) {
        this.io = io;
    }

    public Command moveToPosition(double distance) {
        return run(() -> io.moveToPosition(0.09 * (distance) + 12));
    }
}
