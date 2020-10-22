package dad.javafx.CalculadoraCompleja;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {

	private DoubleProperty real = new SimpleDoubleProperty();
	private DoubleProperty imaginario = new SimpleDoubleProperty();

	public Complejo() {
	}

	public Complejo(double real, double imaginario) {
		super();
		setReal(real);
		setImaginario(imaginario);
	}

	public final DoubleProperty realProperty() {
		return this.real;
	}

	public final double getReal() {
		return this.realProperty().get();
	}

	public final void setReal(final double real) {
		this.realProperty().set(real);
	}

	public final DoubleProperty imaginarioProperty() {
		return this.imaginario;
	}

	public final double getImaginario() {
		return this.imaginarioProperty().get();
	}

	public final void setImaginario(final double imaginario) {
		this.imaginarioProperty().set(imaginario);
	}

	public Complejo add(Complejo c) {
		Complejo r = new Complejo();
		r.realProperty().bind(realProperty().add(c.realProperty()));
		r.imaginarioProperty().bind(imaginarioProperty().add(c.imaginarioProperty()));
		return r;
	}

	public Complejo substract(Complejo c) {
		Complejo r = new Complejo();
		// (a-c)
		r.realProperty().bind(realProperty().subtract(c.realProperty()));
		// (b-c)
		r.imaginarioProperty().bind(imaginarioProperty().subtract(c.imaginarioProperty()));
		return r;
	}

	public Complejo multiply(Complejo c) {
		// (a,b) Complejo 1
		// (c,d) Complejo 2

		Complejo r = new Complejo();
		// (a*c - b*d)
		DoubleBinding a_c = realProperty().multiply(c.realProperty());
		DoubleBinding b_d = imaginarioProperty().multiply(c.imaginarioProperty());
		r.realProperty().bind(a_c.subtract(b_d));

		// (a*d + b*c)
		DoubleBinding a_d = realProperty().multiply(c.imaginarioProperty());
		DoubleBinding b_c = imaginarioProperty().multiply(c.realProperty());
		r.imaginarioProperty().bind(a_d.add(b_c));
		return r;
	}

	public Complejo divide(Complejo c) {
		// (a,b) Complejo 1
		// (c,d) Complejo 2
		Complejo r = new Complejo();
		DoubleBinding a_c = realProperty().multiply(c.realProperty());
		DoubleBinding b_d = imaginarioProperty().multiply(c.imaginarioProperty());

		DoubleBinding a_d = realProperty().multiply(c.imaginarioProperty());
		DoubleBinding b_c = imaginarioProperty().multiply(c.realProperty());

		DoubleBinding cCuadrado = c.realProperty().multiply(c.realProperty());
		DoubleBinding dCuadrado = c.imaginarioProperty().multiply(c.imaginarioProperty());

		DoubleBinding ac_bd = a_c.add(b_d);
		DoubleBinding bc_ad = b_c.subtract(a_d);

		r.realProperty().bind(ac_bd.divide(cCuadrado.add(dCuadrado)));

		r.imaginarioProperty().bind(bc_ad.divide(cCuadrado.add(dCuadrado)));

		return r;
	}

}
