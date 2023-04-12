import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    public class Conversor extends JFrame {
        private JComboBox<String> monedaEntrada;
        private JComboBox<String> monedaSalida;
        private JTextField cantidadEntrada;
        private JLabel cantidadSalida;
        //private JButton botonConvertir;

        private Moneda[] monedas = {new Moneda("Dólar", 1.0),
                                    new Moneda("Euro", 0.84),
                                    new Moneda("Yen", 108.27),
                                    new Moneda("Peso Argentino Oficial", 215.93),
                                    new Moneda("Peso Argentino blue", 395.0),
                                    new Moneda("Libra esterlina", 0.72)};

        public Conversor() {
            super("Conversor de Moneda");

            // Creando los componentes de la GUI
            monedaEntrada = new JComboBox<String>();
            monedaSalida = new JComboBox<String>();
            cantidadEntrada = new JTextField(10);
            cantidadSalida = new JLabel("0.0");
            //botonConvertir = new JButton("convertir");

            // Agregando las monedas al JComboBox
            for (Moneda moneda : monedas) {
                monedaEntrada.addItem(moneda.getNombre());
                monedaSalida.addItem(moneda.getNombre());
            }

            // Configurando el layout de la GUI
            setLayout(new GridLayout(5, 2));
            add(new JLabel("Moneda de entrada:"));
            add(monedaEntrada);

            add(new JLabel("Moneda de salida:"));
            add(monedaSalida);

            add(new JLabel("Cantidad de entrada:"));
            add(cantidadEntrada);

            add(new JLabel(""));
            add(new JLabel("Presione la tecla enter para continuar"));
            //add(botonConvertir);

            add(new JLabel("Cantidad de salida:"));
            add(cantidadSalida);

            // Agregando el listener al JTextField
            cantidadEntrada.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //botonConvertir.addActionListener(this::actionPerformed);
                    double cantidad = Double.parseDouble(cantidadEntrada.getText());
                    Moneda monedaEntradaSeleccionada = monedas[monedaEntrada.getSelectedIndex()];
                    Moneda monedaSalidaSeleccionada = monedas[monedaSalida.getSelectedIndex()];
                    double cantidadConvertida = monedaEntradaSeleccionada.convertir(monedaSalidaSeleccionada, cantidad);
                    /*
                    if(e.getSource() == botonConvertir){
                        System.out.println("asd");
                        cantidadSalida.setText(String.format("%.2f", cantidadConvertida));
                    }
                    */
                    cantidadSalida.setText(String.format("%.2f", cantidadConvertida));
                }
            });

            // Configurando la ventana principal
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 150);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        public static void main(String[] args) {
            new Conversor();
        }
    }

    class Moneda {
        private String nombre;
        private double tasa;

        public Moneda(String nombre, double tasa) {
            this.nombre = nombre;
            this.tasa = tasa;
        }

        public String getNombre() {
            return nombre;
        }

        public double convertir(Moneda monedaDestino, double cantidad) {
            return cantidad * (monedaDestino.tasa / this.tasa);
        }
    }

