package com.example.fakenftmarket.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakenftmarket.R
import com.example.fakenftmarket.model.nfts
import com.example.fakenftmarket.ui.theme.FakeNFTMarketTheme

/**
 * @author : Mingaleev D
 * @data : 20.05.2023
 */

@Composable
fun NFTCard(title: String,
            subtitle: String,
            image: Painter,
            liked: Int,
            eth: Double
) {
   var isLiked by remember {
      mutableStateOf(false)
   }

   Column(modifier = Modifier
      .height(262.dp)
      .width(175.dp)
      .border(1.dp, Color.White.copy(0.5f),
              RoundedCornerShape(30.dp)
      )
      .clip(RoundedCornerShape(30.dp))
      .background(Color.White.copy(0.2f))
   ) {
      Image(painter = image,
            contentDescription = null,
            modifier = Modifier
               .height(155.dp)
               .width(155.dp)
               .padding(10.dp)
               .border(1.dp, Color.Transparent, RoundedCornerShape(27.dp))
               .fillMaxSize()
               .clip(RoundedCornerShape(27.dp)),
            contentScale = ContentScale.Crop
      )
      Column(modifier = Modifier
         .padding(horizontal = 10.dp)
         .padding(bottom = 10.dp)
      ) {
         Text(text = title,
              color = Color.White,
              fontSize = 13.sp,
              textAlign = TextAlign.Left
         )
         Text(text = subtitle,
              color = Color(235, 235, 245).copy(0.6f),
              fontSize = 12.sp,
              textAlign = TextAlign.Left
         )

      }
      Row(modifier = Modifier.padding(horizontal = 10.dp),
          verticalAlignment = Alignment.CenterVertically
      ) {
         Row(horizontalArrangement = Arrangement.spacedBy(4.dp),
             verticalAlignment = Alignment.CenterVertically
         ) {
            Image(painter = painterResource(id = R.drawable.icon_eth), contentDescription = null,
                  modifier = Modifier.size(13.dp)
            )
            Text(text = eth.toString(),
                 color = Color.White,
                 fontSize = 13.sp,
                 textAlign = TextAlign.Left
            )
         }
         Spacer(modifier = Modifier.weight(1f))
         Row(horizontalArrangement = Arrangement.spacedBy(4.dp),
             verticalAlignment = Alignment.CenterVertically
         ) {
            IconToggleButton(checked = isLiked, onCheckedChange = {
               isLiked = !isLiked
            },
                             modifier = Modifier.size(13.dp)
            ) {
               Icon(tint = if (isLiked) Color.Red else Color(235, 235, 245).copy(0.6f),
                    imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = null
               )
            }
            Text(text = liked.toString(),
                 color = Color(235,235,245).copy(0.6f),
                 fontWeight = FontWeight.Normal,
                 fontSize = 13.sp,
                 textAlign = TextAlign.Right
            )
         }
      }
   }
}

@Preview
@Composable
fun PrecNFTCard() {
   FakeNFTMarketTheme {
      NFTCard(title = nfts[0].title,
              subtitle = nfts[0].subtitle,
              image = painterResource(id = nfts[0].image),
              liked = nfts[0].likes,
              eth = nfts[0].eth
      )
   }
}