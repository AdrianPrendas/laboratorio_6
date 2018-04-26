package com.example.esteban.text_appcompat;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.example.esteban.text_appcompat.Adaptador.AdaptadorUsuario;
import com.example.esteban.text_appcompat.bl.UsuarioBL;
import com.example.esteban.text_appcompat.domain.Usuario;
import java.util.ArrayList;

public class CatalogoUsuarios extends AppCompatActivity{
    private RecyclerView recyclerView;
    private AdaptadorUsuario adapter;
    private ArrayList<Usuario> listaUsuarios;
    public static UsuarioBL usuarioBL = UsuarioBL.Companion.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_usuarios);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        listaUsuarios = new ArrayList<>();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        listaUsuarios= new ArrayList<>(usuarioBL.readAll());
        adapter = new AdaptadorUsuario(this, listaUsuarios);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new CatalogoUsuarios.GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Toast.makeText(getApplicationContext(),getPackageName(),Toast.LENGTH_LONG).show();
        //adapter.notifyDataSetChanged();

    }
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}


