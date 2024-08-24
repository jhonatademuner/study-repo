import * as React from "react";
import Grid from "@mui/material/Grid";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";

export default function ProductDetailItem({ item }) {
  return (
    <Card sx={{ maxWidth: 700, margin: 'auto', padding: 2 }}>
      <Grid container spacing={2}>
        <Grid item xs={12} md={6}>
          <CardMedia
            component="img"
            height="400"
            image={item.img}
            alt={item.nome}
            sx={{ borderRadius: 2 }}
          />
        </Grid>
        <Grid item xs={12} md={6}>
          <CardContent>
            <Typography gutterBottom variant="h4" component="div">
              {item.nome}
            </Typography>
            <Typography variant="h6" color="text.secondary" gutterBottom>
              Preço: {item.preco}
            </Typography>
            <Typography variant="body1" color="text.secondary" paragraph>
              {item.descricao}
            </Typography>
            <Typography variant="body2" color="text.secondary">
              Criado em: {item.criado_em}
            </Typography>
            <Typography variant="body2" color="text.secondary">
              Criado por: {item.criado_por}
            </Typography>
          </CardContent>
        </Grid>
      </Grid>
    </Card>
  );
}
