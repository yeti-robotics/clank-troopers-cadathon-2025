package frc.robot.subsystems.spindexer;

import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.util.sim.PhysicsSim;

public class SpindexerIOSim implements SpindexerIO {
    private TalonFX spindexerMotor;

    public SpindexerIOSim() {
        spindexerMotor = new TalonFX(SpindexerConfig.spindexerMotorID);
        PhysicsSim.getInstance().addTalonFX(spindexerMotor);
    }

    public void updateInputs(SpindexerIOInputs inputs) {
        inputs.spinVelocity = spindexerMotor.getVelocity().getValueAsDouble();
    }

    @Override
    public void setPower(double scorePower) {
        spindexerMotor.set(scorePower);
    }
}
