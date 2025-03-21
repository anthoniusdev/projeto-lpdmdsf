import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.projetofinal.R

class ExclusaoDialogFragment : DialogFragment() {

    private var listener: OnExclusaoConfirmadaListener? = null
    private var mensagem: String = "Tem certeza que deseja excluir?"
    private var titulo: String = "Confirmar exclusão"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_confirmar_exclusao, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvTitulo = view.findViewById<TextView>(R.id.tvTituloExclusao)
        val tvMensagem = view.findViewById<TextView>(R.id.tvMensagemExclusao)
        val btnCancelar = view.findViewById<Button>(R.id.btnCancelarExclusao)
        val btnConfirmar = view.findViewById<Button>(R.id.btnConfirmarExclusao)

        tvTitulo.text = titulo
        tvMensagem.text = mensagem

        btnCancelar.setOnClickListener {
            dismiss()
        }

        btnConfirmar.setOnClickListener {
            listener?.onExclusaoConfirmada()
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    interface OnExclusaoConfirmadaListener {
        fun onExclusaoConfirmada()
    }

    companion object {
        fun newInstance(
            titulo: String = "Confirmar exclusão",
            mensagem: String = "Tem certeza que deseja excluir?",
            listener: OnExclusaoConfirmadaListener
        ): ExclusaoDialogFragment {
            return ExclusaoDialogFragment().apply {
                this.titulo = titulo
                this.mensagem = mensagem
                this.listener = listener
            }
        }
    }
}