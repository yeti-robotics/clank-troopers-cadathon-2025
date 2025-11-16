package frc.robot.subsystems.spindexer;

import com.ctre.phoenix6.hardware.TalonFX;

public class SpindexerIOTalonFX implements SpindexerIO {
    private TalonFX spindexerMotor;

    public SpindexerIOTalonFX() {
        spindexerMotor = new TalonFX(SpindexerConfig.spindexerMotorID);
    }

    public void updateInputs(SpindexerIOInputs inputs) {
        inputs.spinVelocity = spindexerMotor.getVelocity().getValueAsDouble();
    }

    @Override
    public void setPower(double scorePower) {
        spindexerMotor.set(scorePower);
    }
}
