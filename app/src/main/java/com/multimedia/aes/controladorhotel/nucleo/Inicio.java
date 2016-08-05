package com.multimedia.aes.controladorhotel.nucleo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.multimedia.aes.controladorhotel.R;
import com.multimedia.aes.controladorhotel.daos.HabitacionDAO;
import com.multimedia.aes.controladorhotel.fragment.FragmentHotel;
import com.multimedia.aes.controladorhotel.fragment.FragmentReservar;

public class Inicio extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private LinearLayout llInflar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        String img5 = "/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\n" +
                "HBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\n" +
                "MjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAFvAiYDASIA\n" +
                "AhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\n" +
                "AAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\n" +
                "ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\n" +
                "p6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\n" +
                "AwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\n" +
                "BhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\n" +
                "U1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\n" +
                "uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDzPywR\n" +
                "1pwTnHrxTgAeuBUqhexrE1IhGKcIxknFSYx2pR+FAEHldV7GgQjA4qxgH696MdsUAVWgyCKi8jY4\n" +
                "OM1o7CKYy8c0hmbIuRzWVPH/AKTF6FhW5JH1PpWZcKPOgPrJTTBh5H3qY1v8o+lXgoO+oz9wH2rJ\n" +
                "SZdih9nGM4p/2NWGcc1ZZSE3Y4NOGAAQe1PmYrFQWYU85FeifDyILpt8epEqAE9QMNXEL8/ykdf5\n" +
                "16D4CUf2ReN6zoP/AB0007sUlaLOlIphFSkU3bWhyEeKUCn7adtoAYFpdtPC0uKYDNtKBTwtKFoE\n" +
                "M20u2n7aXbTAjxRipNtG2iwDCyRLudgo9SaElif7siH6GqGvfLYr7uKpLgu67QcH0qooznPlOhAp\n" +
                "cVhAsp+Uuv0Y1KLmdek7f8CANXyke1NbFLtrLF/cL18tvqCKmTU2/jtz/wABYGlylKrEvBaeE4qq\n" +
                "mp25++JE/wB5asx3drJws6ficUco+dAUqJk5q3gMMggj2qFl5osVcrFOKp3I4rSZeKoXQxRYRmkf\n" +
                "MaUdKXuaO1DAjI5prjin45oYcUIRUcVGRUz1CaBkTVEwqZqiNIZGRTSKeaaaQCIPnFTAVEn3xU4r\n" +
                "GpudFHY6XwqP9JT/AHm/9Bra8S4/sk/9dF/rWP4VGbhfq38q1/E2RpY/66r/ACNC+E2RxxFNxTzS\n" +
                "VmUNxxRinYpQKYhoFOxS44pcUAU7xtsTn0Fc0483TLdP+ekuPzY10Ooti3lPtWBZrvg01e2d35ZN\n" +
                "UgLZw19MfTArY8FAv4yXGDh0HP41jRjM8rerHtW/8PV3+MskZ+Yf1poJbHUwgz/ErUG9LkD/AL5Q\n" +
                "V2/hf95rOpycHc5/9CrjtFUS+PtRc9rqX9Diur8HbpBdMCd8q5Bzjkmt+r9SJ7HdUVz8ltqtkA0d\n" +
                "3Ky+jEP/ADyanhvNWwA1ukn+1sK/1oM7GzRWYZtQOC1kv/AZSKKdhWPlEqMD2pMAcYpR8vBpyj5S\n" +
                "D19awNRVA9Rn86DxycUzbjnnHtQqhsnJx7mgB2TnjA+lSAEAYwKjyWOAMY96acjILfpQBKScdT+V\n" +
                "Jt4PWmoORnNLuPNIZDIMoxrInH76L2bNa7DKHPSsu5/4+I+nLUhsk3YD/lTXHykd+MUHqfc5pM7n\n" +
                "H1FZFj3PQD2FIVAbnoP5Ubhup3DN7EUAMzg/KOleieARnSLv0NwP/Qa8/G1ZBk8kc16N4BC/2FcA\n" +
                "dftJ4/4CtVDcmfws6TFN21MVpu2tjjI9tLtqTbShaAIwtOC1IFp22qQiLbTgtSbaXbTsBHto21Lt\n" +
                "pdtOwrkO2jbU22jbzTsK5i68P9FiX1kFUgMSTEds1oa+P3dsPWSqajLTe+7+dVFGFV6o0Bo5YZSc\n" +
                "jPOCoOKY+k3IHyvG31yP8a3EXCj6U4rTL5Is5l9Pu16wbv8AdYH/AAqJo5Y/vwyr65Q+vtXVbaXZ\n" +
                "QJ00ckJFzjeM+hOKlX5gMgN9RXUGGNxhkUj3Fcnp6BYSFAC7zx+JqkZThyq5s6QmLebA480gD8BV\n" +
                "p15pmlLi1lP/AE1arDLzSaNofCis6/LWbd1ryD5aybypLM3uaMcUdzTgOKQiPHNK4+Wngc0kg4pg\n" +
                "UZOtRGpZOtRN0pMaImqI1I1RmkMbTTTjTTSAE+/U4qBPvirC1jU3OmjsdP4UH77Ppu/pWp4n/wCQ\n" +
                "Yn/XZf5NWb4TXMp9gx/lWj4n/wCQfH/12X+TU18Jr1OSNFKeaSsygooxSgUAKKDxS01+FP0oEZGr\n" +
                "SbLKQ+x/lWXpS5jtP9iDP41c119unyf7pqDSRizQ+kKj9KroCHwjAz3LZ/Wum+GcYfxWW9Mn9K5p\n" +
                "Th8V1PwuUnxGW7ZP8hVR3CWx0Pho58Ra3c9lnuG/Jz/hXX+BxxIf9lR+prkPDuFi1yb1ac5+rN/j\n" +
                "XVeBWOy5wCxXbgLWvX7yZ7M7drhUDFkkAHohP8qSG6incqhbcAGIZCOD9RVO8W/lDC0lkhc4KllR\n" +
                "l9xjr+oqeySV7NftRUyNy6qCAD6c88UzLoW6KKKBHx8Gz3HTPSjJDdR+dYQupR92Q1Kt7MOr5/Cu\n" +
                "e5vY2h7nimscZwfzrLF/MQANpxTlv5AOVGfXNLmCxojhSQcnvSqAcljVAaiSMGP8jTvt6EcqwPtR\n" +
                "zBYvZ5J7UgPB7ZPWqi3ke3GT+NKLqPGA5/OjmQWLLgbcY9qybnm6j+tXftMZU/OoP1FUp8tcxsoJ\n" +
                "GeTTuFgLYb8KYH+bP40/y8sQQRR5Q4HrWd0WNCu54qSNWU47iplj2nHpQEI+tK47DHjJO4d+K9D+\n" +
                "Hin+zLkHp57f+grXn7Aqp9mr0v4fr/xT8rdzcuP/AB1KqD1In8LOlK0m2pttG2tjjIttOC1IFpwW\n" +
                "mgIwtLtqTbS7apCI9tKFqTbRiqSJGbaMVJijFVYRHto21JijFOwjD14fPZL6y/4VVjX7/vn/ANCN\n" +
                "XddGbrTx/wBNP6iq0IyT9QP1qorcwrbo6VV4pdtOApxFBsiLbTsU7FLiiwxuMAmuQsFzbrx97JH5\n" +
                "muxfiJz6Ka5LTx/osPpt5/M047mNbY3tKX/QmPrI/wDOpmHNR6SP+Jcp9Wb/ANCNTsPmoZcPhRBI\n" +
                "PlrIvRW1IPlrGve9QyzLA609RxTR3qRelACAVHN0qWoZjQIpP1qJqlfrUTVJRC1RmpGqM0hjaaac\n" +
                "aQ0gET/WCrAqCP79WBWNTc6aPwnV+Ef9Y/8Aut/MVd8UH/Qox/01H8jVLwnwzH/Yb+Yq34oP+ixf\n" +
                "9dP6Gn9k1W5yxooNFZjClpBS0ALUcvCGpBUc33RTA5zxE23T3HqKfp3y6ZGfVF/kKg8TNi2256kC\n" +
                "rNoMaXCP9gU+gLcaOHH0/pXZ/CiMNq87EdMkH8q40jk9eAa7b4Xfu5L2X+7ET/n8qqG4S2NPw/z4\n" +
                "Z1O4x98Lz/vN/wDXrqfAB/0m7X0Az+tcxouI/Ak2f4jGv5bT/Sul8AsBe3xJwML1/GtexMvhZ3uQ\n" +
                "pOT1pqzRmQxh13jqoIz+VQXM91C58u086ILkkOAQfTHes/S9Qg1OZjb2EkLQMA/mxmMqSMke/BFM\n" +
                "yt1NuiiigR8OEcdaPY4pSQe9KPrXMbiZAPalyMcfoaM++aUZpAGcDJzSbhjqad1NNK56Y/KgYeYB\n" +
                "3pC3v+lHl8ev4Ugj9hRoA3cfX9KcGb1o2EdqUA+lADZJvJj3EnGccVPDOxGRJweaiOMYZQR70qMP\n" +
                "ShpWGix50g6OtOE8mc7kP4VAHHTbTtw/uj8qmw7lkXTsMMsbD6H/ABrvvAGvWwQ6O8flyvI0qMDk\n" +
                "McDI9uFry27kkDLsGF9h3rpPC8jL4i0tlyMzRg5464B/rV8trMm/NeJ7aFpQtPVaeFqzksRbadtq\n" +
                "XZS7aaAi20bak20batEsiIoxT9tGK0RIzFLinYoAqkSNxRtp+KMU7CMLWh/xMdOH+0T/ACqC2X5g\n" +
                "cdZFHT3qxrP/ACFtP/E1DafwE4Hzp/OnHqc9X4kdKBS4oUg8gg/Q07FNo3TG4pcUuKXFIdyK44tZ\n" +
                "j6If5Vylgv8Ao0IPXFdVd8WVwf8Apm38q5iwGIIeOMCqjuYV3ob2kj/iVxH13H9TUzD5qj0oY0q3\n" +
                "/wB3P61M33qTNYbIhkHy1i33etuT7prEvu9SyjLHepV6VEOpqVRxUoBKgm6GpyarTmmxIqN1qJql\n" +
                "Y81E1QWQt1php7Uw0hjTTTTjTTSAWP79WFqvF9/8KsCsam500fhOu8KDCnPdW/mKm8Un/R4B6uf5\n" +
                "VF4X4jB/2T/MUvik/ubX3Zv5Cn9g0W5zdFJmlqBi0tNpsh+Q0AS5FQzEHHNQ0HpQBzXiV87B/tCt\n" +
                "KMbLKFMdEUdPasjxB893Cg7vW5Iu1AMdKfQa3KjEhX/3T/Ou4+HuItL1WT+5bSN/461cOeRJ7Acf\n" +
                "jXeeC12eEtebHS1l/wDQGq6fxIJGlAPJ8DwL03TDP5Guk8BIrTX4YKQwXg8jvXOXZEXhHT0PG+Vj\n" +
                "+VdR4AXbPeD2Bq+qIl8J10liXlDrczoAMBFbjPr/AJ9Kq/bru0vRFdxboZG2xyxj1PcfTvWqSMgf\n" +
                "ypCOc81RncbE5kTcQBn0OaKVI1jXagwPSigR8QbPagLj1pOD3NA/3vzrmNx2RQB/nNNwf7wpfm9c\n" +
                "/SgB4GOpozTMsOlKOvNKwx4pRTcjPenAjHBpDFpwHHSmgj1FPHTqKQCY9qQRqewFOzSjvQMaIR6n\n" +
                "8KXaF6L+JpeB04oDe+RQAmCSOeK1PDYP/CS6YP8Ap6j/APQhWaGGa1/DIz4n00YP/Hyn8xTA9yUV\n" +
                "IFpEFSqK0OMTbRtqTFJimgIytNIqUimkVoiGR4puKkIpuK0RLG4pQKXFLirRI3FGKdigCmIwNYGd\n" +
                "Zsh6Kx/nUKRyIgAXPHQ/Sugnsre6IM0SuQMAnqKh/sazPRXX6SN/jTjoY1IOTujHO4dE/L6U5ZpF\n" +
                "HytIMeje1ah0WL+C4uF/4Fn+YpjaPIPu3j/8CQH/AAq7mfsZFJb2cE4mk/nUg1O4UZMqke61I2k3\n" +
                "XaeFv96LH9aY2mXo/wCWdu30cj+lF0HJUQs2oyzW8sLeVh1KEjtnis+GLylVc52gDPrirbWN2M5s\n" +
                "y3+5KD/OmfZ51PNpOpPGcAj9KehMlN7mvpgxpdt/1zFSt1os4zFYwRsMMqAEfhSt1NZs6o7EMv3a\n" +
                "w77vW5L901iX3U1LGjKB+Y1KvSoM/OalB4pIbA1VmNWGNVZTzSYkV2qJqlaomqSyFjzTDT2plIYh\n" +
                "pppxpppALF9/8KsDrUEX3z9KnFY1NzqpfCdh4Yx5AH+yf503xWeLQe7/APstSeGU/wBG3ei4/M//\n" +
                "AFqreK2/eWo9N/8A7LT+wX1MDNGabnikzUDJM0yQ/IaTNIx+U0AR5pSeKSkc4BzQBy+pfvdctU6/\n" +
                "OD+tbkpAGaxGG/xPCP7oJ/StmYnaTmmyluV+PLf8BXfeFVx4K1n/AGoWX8+P61wSjMT/AO/j9K9D\n" +
                "8Nrs8B6g2OWZV/NlFXT+IUuhY1rC6TpUB7Rl8Y9TXWeA8faLoj+4tcl4jbF7DB2ht1U/kK6vwEN0\n" +
                "12D02r/M1fUiXwnc/hQelA96DnBxwaoyCiiigD4dOAeopQeOK0yMnlLVv+BY/rTTHn/l3tj/ALsn\n" +
                "/wBeua50WM/AJz/SjaO1X/s65J+yA/R6PsqH/lxm/wCAt/8AWoCxn52npS5yKvtaRDrazr9f/wBV\n" +
                "MNvbAcpcL+H/ANegLFUEU4YNSiC2PSScfVB/jR5MQPyzt+KUrDsRjFLtGKm8pP8An5T8UP8AhUbx\n" +
                "lVyssbewBpWATjFKAB3NV/NkH/LNaQTyAZ8sYo5WF0WSf9pqilkEEfmMzYz2FRG6J/5Z/rTvtDEY\n" +
                "MZPtmnysVyK6immaKSLJUjIxxiuq8Jqz+KNLUqB++UkdenP9K51bhycbGr1D4ceH0ZV1ucgtgrCg\n" +
                "/h6gk/rTk27IFZXkejotSAU1alFM5xMUYp1JVITGEU0inmmmtUZsYRTacaStEQxKBS0CrQhKUCii\n" +
                "mSKKeKYKeKdgCloooASjtS0UAAoI4oooAYaiPWpTUTdaAIZfu1h3/U1uy/drBv8AqamQIyD981Ip\n" +
                "4qEn5zUqnipQMRzxVWQ81O5qtIeaTGiI1E1SE1E1QURE802nGmmgYhphpxpppAPi+8anFV4fvGrA\n" +
                "rCpudVL4Tt/DA/0Jvov9azvFX/HzB/un+lafhoYsT/uj+tZPikk3sS/7H9ap/CWjCB4pKXpSVAxa\n" +
                "Q9DRSHoaAGZpr/dNKKa5wpoA562G/wATyf7EZrVmOQRWZpw3a9eP6IB+Z/8ArVpT/eHvTZSGR8wf\n" +
                "VjXpvh+Mf8III/8AntdRr/4+p/pXmkQ/0dPck/qa9U0ZPL8JaSgHL3i/oGP9KunuTMy/ED7tZuWP\n" +
                "QED+ldb4HaSKW+ZYmcb0VtoyVHPP6CuJ1GTz9RuyP7/9a7XwlexWVvfM6XDNJKqr5ERc5wewqluw\n" +
                "mtLHZSalYwOI5rpIXbhRKdh/Wrg6DJz71lx3OnzbRNMzskm5ftKFdj9cDIAzz0q+jrOODlQQQwPU\n" +
                "59qq5i0S0UUUxHxrubu8v/fR/wDiaMk9ZD+I/wARWUNRiI+aD8mp41CIdIWH0Nc1mdN0aXXgSL/3\n" +
                "ytJj/biP/bNP8azxqMX92b8G/wDr08alBjkXGfZv/r0WYXRdBOePK/75A/kadlzwAv4b/wChqj9v\n" +
                "t/WcfXBpfttqerv+KD/ClZjui/mUD+IfR5BSFpQOQxH++39RVAXULOFjKtn1UD+lW4VMhAVOf90U\n" +
                "WGh/mZ6rj6yL/UVFKQy4xg5H8SH+QzV25tJIolbfyeir1/nVArLuG7djPds/1pJphJNFTaTuxRtP\n" +
                "lkUoPDUikjI9aozIsEtyKsImCfpSMm0+tSLxnPpQ2CQ6NOF49a9k+Hw/4paH/ec/+PtXj0Z4Ar2P\n" +
                "4fr/AMUrBx3f/wBGPU31Q5fCzqhTxTVUkgAEk9BUwt5v+eMv/fBpucYvVmKhJ7IZQam+y3GP9RL/\n" +
                "AN8GmPG6feRl+oxVxaZLi0RGmmnkUzFbRMmNNNp5FNrVEMSiloqkSxKWiiqEKKcKQUo6UwCloooA\n" +
                "SjNIaKBDqQ0A0UDGmoj1NSGoj1oERS/drBv+prem+7WDf9TUyBGMT85qVelQ/wAZqUH5azQ2ROar\n" +
                "vU0h5qB+tJjRGTUTGpTUTVJRETTSacaYaBiE000403HNICSLqamFQxd6mFYT+I6qXwnc+HCRZH/d\n" +
                "X+tY/iY/8TFP+uY/ma2vDwAsT/ur/KsLxIc6oP8ArmP5mqfwloxyabmgnmm1Ax2aQng0maQng0AI\n" +
                "DTJD8ppQaa5+U0AY+lDN/qDf7aj+dXJuvNVdIGTev6zkfkBVmc9T6A02Uh0f+qiHqBXrVsPK0TQY\n" +
                "8f8ALQyH8EP/AMVXlMK5WFe2ADXq143kDQbf/pjIxx9E/wAa0p9SZbo5VsNNO396U/zr0PwTeW9p\n" +
                "bXfnuF3SgBsccD/69edx4dC3bz+vX+IV3/hGWWHTLprZN9w03yr5ZYYwM5PbrREKh2S3FheZjWW3\n" +
                "myeV3Bsn6VYAWPCKoUc4AGBWcIYb6WCa5iiS4tpMjjnOCOvpzn8BWmDkZHSrTMWgooopiPhr7HKP\n" +
                "+WdAtJs8xmtwR04RVPKg9ozB+yS/882pfssn9w1vCLNBhpcge1fYwfs0n9w0020g52N+Vb5gppix\n" +
                "RyeY/a+Rgm3k/uH8qcrXcYwks6j0ViK2glTxrzUuJSqEPh+f7Q7WNyW3n5ombqT3Wp7kxwuICP3p\n" +
                "646LWnYwlpFwOc0zVz509xvhCvAwG9f4sqDyPXmueUbSv0OiFRSjy9Tm1XBPemuvzD609D8/4U1x\n" +
                "+9Unpmq6kB1fB5qRMBcHrio8fvTiplX5RxQwJFA+XHvXs/w9UHwrb/Vv/Rj140B9wY717T8OVH/C\n" +
                "KQfVv/Q2qW9UVb3WdbaRbruEf7YrpEh5rF05N2oQj3P8q6dUFc1Si6s15EqXKrDEjxWdra4slHq4\n" +
                "/ka2AKytd/494h6tn9K7I0+RGTlc5llqMrVlhUTCuiLMZIgIpuKlIqMitkZsSkpTRVohiUUUCqJH\n" +
                "Clpopc0xC5o7UlFABSGjNJQA4UmaSg0BcQ1ETyakNRdzQBHKflrBv+9bs33awr89aiQIxSfnNSg/\n" +
                "LULH5zTwfkNZotkTnmoW609jzUbGpY0MNRPUhNRNSGRmm04mmGkMDTaCaQmgCWI9alBqCI9amBrC\n" +
                "fxHVS+E7zQ1zYY9k/lXP+IGzqhH+wP610OicWJx7f+giuc17/kKyA9QBVS+EtGW1MpzU2oGBppPF\n" +
                "KaYTwaAE7U1/umjPFNb7v4GgFuUdIT/RZW/vzOf1x/Sn3J+RvU8U7ShjT09yx/8AHjUN1y4Ge4FH\n" +
                "UpbGtYxebe28Xq4Fej61Js1yyjPSGx3demSf/ia4Tw4nm65AD0Bziuw1CcXPja7tSufKs4kyD0zu\n" +
                "P9a1p/CS9zDtT+4Vcj5nB5Pqa9K8ICN9FuUe4MQeYjII9BXm1uGEMRA+ZZcY+lepeD2gtdIYyzxx\n" +
                "lpXYKzgZHAzinHYVQvyaVDfSQSahIJJ4X+VoMrvGON+Ovr6VtYx0rNtZ72aSbzPsybHIjwcl1z35\n" +
                "4zxWipLKCQRnsapGcri0UUUyT5EEHtTxB7VdWAntU6W/tV8pg5FBbfPan/ZM9q1I7b2q0lqMZxVq\n" +
                "mQ5mAbIgdKje0+XpXSvagL0FVJoVVOlDp2BVDlpI9j4NSRD5hUt6MSjFRxdRWElqbxehuWLBCpFV\n" +
                "9TIaO/bHWUc/8BSm2z4xUV6+UvlPUuMc+y1zVXol5nTRWr9GcxySD6inSH5qaxIPFK3LfWkUOXl2\n" +
                "JFSKcrQeHxQANgoGTg/Kh9Divafh1j/hFYfq3/obV4oowi855r2f4dtjwrB9W/8AQ2qGtUP7LO90\n" +
                "oj+0Iz6A/wAq6RHBrlNPl23QPoDW5DcZPWuadd0qvKLkco3NQGsbXW+WEf7x/lWikuRWNrkuZYh6\n" +
                "KTXdGfOjFxsZTVE1OZqjY1vFGMmMamHrTmNRlq2SMmFJmmlqTdWiRDY7NJTd1JuqiSUGlzUW6l3U\n" +
                "WEPzSmo91G6nYBxNJmmlqTdRYLkmaM1Huo3UrAKxqImlZqiLUWC4yU/LWHfnk1sSt8tYl83WplsC\n" +
                "Mhj8xp2flNRM3zGgv8lYo0GMeajY0jPzTGakyhWNRMaUtUZapGITTCaUmmk0AITSUhNJ70DJou9S\n" +
                "ioIjwalB5rCfxHVT+E77RwosyTnOcZB9hXOa62dXm+i/+gitSz1KzsoHhldYlDbsuwUdB3NQyy6N\n" +
                "dO8zy27Ox5YTL+Hf0xVvWJZzrHim5rbePSs8GMj2lH+NROukAqNyDPTEnH86zHYyaa3Q1qmLTM8M\n" +
                "v/ff/wBemNFpvc4/4Gf8aAsZJ6U2QgRuf9k1rbNNYcNF+MuP61m6l5KRyeTt2hOSrbhTa0BLUqae\n" +
                "dumwnnlM1Xny06epcVdtk2WMS/3Y1H6VUT5rtPTJJpdR9DrfB0Bk12PgcDua0oJvP+IevPj7rRxg\n" +
                "/wC6gqLwLFnVTL/dFV9JuBJ4t8Syn7q3Trn3AA/pW8fhRD3JbaZXvJEcDYJMgDry1ep+G2m/sN2t\n" +
                "miZRMf8AXDouBnn65rxq2nEd47tzk56+4r2TwY4fTJHQFgWGcnA6Z6fjRB3Qqm5eGg6fc6omrBE+\n" +
                "0qu0hVGw9ecevua2qgRGQFxHHCScsF53D8hzT4WkePMqbGyfl9B2/GmjNu5JRRRTEfM6Q89KsJD7\n" +
                "U9QBTwa7VE4HIVIhUygAYxUQanhqqxDYk3Ss64+5V+VvlrPnPyVEionO33+tFRJU19/rBUKVxT3O\n" +
                "2GxegOCKfcxg2l9Jxneo/RaghPSpZxm0vTn+Mf8AoK1y1P1Omju/Q5V+CSKRslj7YpC/BokJ3YFM\n" +
                "onz+8FKM4x3FQM5FTI+459RikBID8i+xr2L4duf+EXiz6tj/AL6avGg+FHua9g+Hrf8AFMxfj/6G\n" +
                "1CXvIU37jO0iuPJfeQxHTgZrQtdRiLYLEf7ykVjhqJJPLhkf+6pNZ1sHGc/aX1QUsS4rksdfFewk\n" +
                "f65P++hWVq06yXS7WDAJjg+5rKLc0F8V1U6dkY1K3NpYlLUxjVWS9jjzk1WfVIR3rdWRg7l5mHrU\n" +
                "RevLvEvjbXtJ1eSHdFHA3zQ4RWyuTg5rGPxJ13H+sQn2iX/Cq9pFB7KTV0ezl/ek3j1rxf8A4WRr\n" +
                "5/jX/v0v+FB+I+ujrIP+/S/4VSqxF7CZ7OXHrSb+eteMf8LH1v8A56f+Ql/woHxF1nvMR/2xT/Cn\n" +
                "7aIvYTPaA/vS7x614v8A8LG1ntMf+/Kf4UD4ia7n/Wn/AL8J/hT9tEX1eZ7TuHrRu968ZHxC10n/\n" +
                "AFrf9+Upw+IGun/lo/8A36j/AMKftYh9XmexE+9Ju968hHjzXc8tL/3xH/hTv+E81v8AvTf98Rf4\n" +
                "Ue1iH1eZ66G5pc+9eRL461w/89z/AMBi/wDiakXxzrfdLg/jF/8AE0e0iL2Ez1ZqhavNk8Za03WC\n" +
                "6P0eH/4ilbxZrA62937/ADw//E0+eIvYTPQJm4PNYd8/XmuTfxdqrdbe6I/66Q//ABFZ9z4l1Bwd\n" +
                "0FwPrJEf/ZaiU0xqjJHQtINx5pplG3rXEy+Ib5STtcfXYf6VVfxNf9Aw/FBWN7Gvs2dwZRnrTTKP\n" +
                "WuFPiS/P8Q/74FNPiO/9V/75FK4/Zs7oyj1pN+a4b/hI78d0/wC+a0dH1e/vrvawjMSjLnGCPSkD\n" +
                "g0dOTTSaaG4ppNBI4mm5ppNIWpATxH5alzVeIjbUoNYS3OuHwohv59VuIvITyZIyclpMhuvqpH8q\n" +
                "zfseqgAKVH0bI/U1tA07NHMyjDa31gnBWAj1xz/OmG31rOFSI/iP8a3iaAafMBz/ANk1fbj7PEfx\n" +
                "H881Os3iSKIQrtMa8AMVbj05zW3mjNHMFjAa88RJ0toT/wAAWrgluW0gtcqqzMCGCqAB+VaJNVbr\n" +
                "BtVH95v5mhyuEUW/uw49sVQgy119FP8AOrkpxDn2qlac3DH2FJFs9D8FqEEkucEDvXO6FdKbjU5m\n" +
                "/wCWl1OxPrlzW/4eP2fTjIeh5PFcL4dmMmlvITy8jsfxYmtnpFGa3NYODKTtDAnGK9c8Bi3fw7Ks\n" +
                "krwjzsAhyD91a8aLHB712ega59i0SJWhmZmlfPlkccL7ilSSbswqtpXR6nps+Gdr24Z3zlNzKVA9\n" +
                "gO/PetP7bbf89lrytvE2R/q7xR7sB/7NUD+Jxu2+ZdqffJH6Gt+SK6nO5yfQ9cF7an/l4i/76FFe\n" +
                "NyeJsH/j6mX6of8ACinyLuLmfY4j/hIdN/56yf8Afpv8KP8AhItO/wCekn/fpv8ACvPt4bvRkVn9\n" +
                "ZmP6rDzPQv8AhItOH/LST/v23+FH/CS6b/fk/wC/ZrzssKO1H1mp5B9Vp+Z6E/iXTmX78v8A37NV\n" +
                "pNesWXAaT/vg1w3TvS5/zik8RNjWGprudDdX8Ergrux7rUaXsAHVs/SsDaCeufpRsrJzbNVTijpo\n" +
                "9Qt0xkt+VSSanA9vcxqWzIwK8eyj+hrlNtOC1Elc0jaL0LfkknPTnPWn+QS+cr+dZ8hZQCqFsnn2\n" +
                "p4Ix3NKzC6LxtyehX86fFbPk7mUenzCs8AdhS7T6UrPuVddjUFmQow6Hv96vWPAMc3/CPIojZiM/\n" +
                "dGf4m9K8VVADya7f4e+I7zSb+WxtiXjuF3CMtj5x6cHtn9KcU1JMUkpRaPWLqVrG2a4uIpViQEs2\n" +
                "w4UAZJPtWfNrenz6ZLIl4ojkiYrIUcrjHXIBGKgn8S61Mux9MEi+jsWH/oFVG1K+cf8AIAtf+/ef\n" +
                "/adbyhVfYwjGmjfXVdPNgbxb+3MHADbsbyTgBc/eP0q2sN1PDvW1nAPqhBrmotW1OIYTRbdAPSJv\n" +
                "6R1ei8Ra6oCi1VF9Asv/AMbqlGaJcIPYh1Ow1EEuLWfaOuENc9PM6ZHII9a6+PW9YlYL5CAk4yyy\n" +
                "gfmUFZHiTULhozbXdrbeY6hhIoyVGexP0rOVJ/E2PRLQ8s8YuZdQt9xziL+prAjJWTGBwv8AhW34\n" +
                "rOb6H/rn/U1gBsSt67aa2LhsXFkZh8o470x09iKiVo8DcDn605mjI+4T+NSaDSjdQKTY2eg/Slyj\n" +
                "dVP50o8vslMVg2ORnA/MU5VfP3R/30P8aTKj/lmPzNPWRVBPlKR36mncLDwren/j4/xpcN6fgWH+\n" +
                "NW7VLW4H+rGf94ipzb2gyTHkDtvb/GncLFBSxPr/AMCH+NODsvO3/wAeH+NXIDZJMrfZwVB5ViSD\n" +
                "+tWbq2s453iCDYVDo2TnB/qOn4U09Lk21sZqzsP4f/Hh/jUqXDKB8n/jwqwsFsMK9umfXn+dT+Ra\n" +
                "AcxKuPc0+YfIyGK6JHQ+/wAw/wAadJcuThVbp2Yf41OiwITtjUfhUdwsZhlcDACk4z6U+cOQpT3L\n" +
                "5IKsOf7w/wAaoTTM2OGH/AhVrchP3Fz+dSoyYxtA+gpOQlEw5Fkc/Kjn6DNVmhlDYMb5+ldWFwAc\n" +
                "4qJxj5HOQfWpuPkOY8iX/nk//fJpwtLkniCT8VxW9FcMtwbd85xlCT94f4+9TdyD16/UU+lyba2Z\n" +
                "ys0bxSBJFKt6GtvwzxJcH2UfzqHWrfMaTgcqdrfTtU3hzpcH3X+tCIqKyOnDcUu6olbijdQYjy1N\n" +
                "JphakJoAmRulThqqK3SphJg4rGW51Q2Jw1PDVAHp2+pKJC3NAaoS3NKrUwJ80ZqLdRuwKAHu4Cn1\n" +
                "xVa7YDyE77l/nT2bcCPWq86NJJG5kACsD096dhpl65OIse1VLAEzP+FE17buxHmpkds0unzQi4IM\n" +
                "iAZyeaSQ2dp5otvDdw3QrCx5+lcN4bYjSFX/AGm/nXS6nfQy+GrxYpQ2YyvB9a5DR5TFaxxB0DfM\n" +
                "xVnC9z61tLVWRK3Nwv8ANjtXSeH5gtvICQQGX+v+Fczp1t9vd2FxDCg5LO38q2LBDYy3EJlWQFx8\n" +
                "wGOmf8aUItO7CTudcsikdBTZPLI6Cs+K44HNS+dkZzWjZFhJIkY9KKjaTJoqblWPDguD6UHkUEGk\n" +
                "UEHnisRigA0/GKjJwfakDD1NFguPPoTRkAUwkHoaac56UWFck4zS5wP/AK9QEnNBY5p2C5McetJu\n" +
                "FRnNHOaLDuSk0Ag+9RZNODHNKwXJA2OlOyfWogRmpA2V4pNDJFXJ+tdH4LUDxdp+D1Y9/wDZNc4j\n" +
                "cc10PgnP/CX6eevzN/6CaFuhntgqQLUa59KbeMUspWBKkKTkdRXecxNHJFIzKkiMyHDBTkqff0qd\n" +
                "VFct4WjsYtU1eOzjcMXiklZiTuLLnv7k/nXWLQgBx+7/ABH864vxg+3UYx/0xH/oRrtJTiL/AIEv\n" +
                "8xXCeNnxqcQ/6YD/ANCaomroUtjzTxQ+b6H/AK5/1NYOcSvjn5a1vET7ryP/AHP6msm3ia5uhFGG\n" +
                "LsMKF6k5rFqxpB+6h4ORyKcpLkKqliegAzmuz0zwLCY0e/nkZzyY4yAB7E45rrbDSbLTlAtbaKM4\n" +
                "wWC/MfqeprmlXittTqjRb30PNbPwzrF7gx2Mir/el+Qfr/Sty18ATnBu9Qij9olLn8ziu82MT1wK\n" +
                "t29i0rZ2nb61CrSlokX7OK3OTs/COjWeGljlu3HOZWwPyGP1zUusm2OjT2C20MEDrgbFwFI5B498\n" +
                "V2cmloYiNv41wOvRvFLLAW4FN86d2K0WtDzqJtkoGACO4rSVyVyCay5QUnYdw1W4JtmNykD1rpRg\n" +
                "SFz3arlzKJLG2kbO6NjGW9uq/wDs1VzCswLLk8dqW1BeG4tmO7K709cjn+WR+NaR7EVNr9i3aTrI\n" +
                "pilwQOhpZW3yMcEL2BrNaQxbiD0w2R6Vpecs1urDk45qTS4sTE9D0HSrChHUjbxjketVIgFOSGHp\n" +
                "UwkYZ2jjGKAMaLfHIYnI3xttNWSw+63yt6+tQahG4vkmK4WT5cgdx/8AWqZiAgEvTsR2oEWUY7dk\n" +
                "n50oQhirDK9qii+XAY5B6N2NTPJsAy3y9jQMpXoGzzEGXiO4Dv7/AKVK7Bo1kU5GA2R6dP8AD9aZ\n" +
                "dEoROhB2kbgD2pbUiSDAOV+YDPYc1Ud7GdTa/Yl2RTqFmTfGSN65xkZrdTwd9gDyWExljkwwV+oH\n" +
                "1rnjL5fLdMV2HhbVRPbvYOTvgG5Se6H/AA/qKzldbF8qlozDkjkhcpKhRh2Ipu6uyvVtZFInCke/\n" +
                "auYvYLGMkx3ITHZjkUlU7mUqDWxT3U0tUe9WBZHV1BxuU5FJuqzFprcsK3SpAarK3Snh6xe50R2L\n" +
                "Aanb6rb6eHpFEpanI/eq5ekElUBbLim781AHz3pd1AE26jrTFNSA0ANZV2nIBqv5SBtyoob1Aqw7\n" +
                "cVCaaBkZXOaaYUPVV/KpKcBVCGwWsZbJRT9RW/bOVArKh4NaET4xTuBsRTnAyatpOMDmsdJQDznH\n" +
                "fFXVh8wKRJ5fqpAYn8cjH60NjsXTKPWiqhtZD92ZfxI/oTRU3A8g3GlyfSlCnp2o2GpENJ9qjPWp\n" +
                "yhHWmFfWmgIj7Uc560/Z7ik2ntTENJPWjNBBpDQA8HNLimKcU8H2oGhMUCl596MH0pAIOtPQ0gXm\n" +
                "nvF5ibQxU9cikxjlJHUV0Xg2WGHxVYySyJGiliWdsAfKeprAVeevNdd4K0qWW7k1RuIbfCKc/eZu\n" +
                "P5Z/SktWVsj1Fdc03te2x+koNObWtPkQo0yMDwQFY5/IVjlaUDFdnOzDlNm31LT4lxEdvbiFv8Ks\n" +
                "DWbb/nof+/L/AOFc/HIjlgjqxU4bBzg+lTgUc7DlN0araTlYVkfezDH7lwM5z1IxXFeOnxrEQ/6Y\n" +
                "D+bVuwnF1b5/56LXMePpf+J1Hg/8u4/9Cane6IqKyPOvEsgN3DjtHj9TXQ+CdBWNV1K5/wBbIMRK\n" +
                "f4V9fqa524gN/rdtCeVIy30GSa9AtZ1Qrt+6gwAK5q2rsbYdWVzoEjVRUsce44GPck4AFZcmoR21\n" +
                "u80jYRf1qzbeXK4luCXPBWIn5FP07nnvXDZX1O67toF/rMWn/LBa3F7N6xRMUH4gc/hXOSeJdTiu\n" +
                "vPkN7F/sLbuFA+mK72G7jVFBC49MdKvRvFJgFUzXRBwexlLmW5wDfEIBMOspb3QjH6Vyt/4iiu53\n" +
                "lkfk+vFe1tbwODlEP1FU5tH0+YHfZwN7mMVco3IUrHz1ezRTXBaM5LHOFp1tKHPl/N9DXtV74J0S\n" +
                "75ez8s+sZxVAfDbw/nIjuPoJSP5VcUQ9zzFWEXJbj61PDdRrcpNEwJRgSjdR9K9Th8A6DEu02bP7\n" +
                "vO+f0NTr4K8Poc/2XblvVstj8zVp2dxNXVjyC5eFpJUClHUkc9+1VYprqFNu4Y98cV7b/wAIpoZJ\n" +
                "P9l2jZ7lAc09fDGiJ00ix/GBf8KNBK6Wp42LpymGZc+1AvQvDOoz6mvaV0DSYyAulWQPbFun+FWo\n" +
                "tPtosbLeCPnoqAc/gKB3PEpib2xaKAM75BUhTwR+FJbWmoMpR7Nzno6KT+BGK918ogbece3FATtj\n" +
                "H1oC54iun38aEnTrkLnDARMVPv0pPsOpEEJp9zIPQwMc/pXuHl4P/wBagxnIBAGT607Bc8Ml0TVJ\n" +
                "QHh0q/jkAx/qGwR6EEVJD4c15FVI9JuB8u0bgBjt3P1r3HygACTzSeQpJ559aBPXc8UHhDxE6MDp\n" +
                "rjI4JljH/s1XrPwd4ihuROkUMTEYbM3b8M168LcH0pRag9s0WC5w58NxYw8LOD1DSsw/Imj/AIR2\n" +
                "2QAC0hX/AIAK7gWascE8UjWCHOB+JqPZlc5wp0C05xbxg45IQA1Wk8MWr5wrp9DXfNpi5P8ASo20\n" +
                "sdqORoG4vc85k8KSA5hnH0cVSm8PanDkiESD/Yb/ABr059LKt0zntSHTmLdOMUuRi0PIpoJ7c4mh\n" +
                "kjP+0pFND16+2mAjDLkHtVCfwtp0/MtmmT3T5T+lHs2B5cXpA1ehTeAbCXJieeLjoGyB+YzWdJ8P\n" +
                "LkZ8i/ib/fQr/jRyMRyINPWt6TwPrkR+WCKX/clH9cVTk8P6zE2G0u6J/wBmIt/KpafYEUQacDT3\n" +
                "sruEZltZ0HctGRUQqShXPFR5pzdKbVITFFOWmCnimBPHVlGqolWFzmgC3E2Wx/sn+VamXAOGHPCg\n" +
                "jpWPAf3o+lau/OPr/Wk2NEm+UHAVDxzkkc0VGJOpopDPKVuUIDKrc+opTcrtU7SS2aVNL1DAH2R8\n" +
                "e+BTv7I1EoF+yNuxjqPXJ71tyIybZELpSSAn45pfPDfwAD1JqVPDuqY+W35PTLCrC+GtWk4MSDHB\n" +
                "+cUuVDuyrCyTE5G0DvWrZ6bp88aGWWZZGJGFIA9u1Rx+FdXU8RxgDr+8HNdJoum3sELQ3kUJVTlC\n" +
                "CD/Sk0kXFN7mMdK0tfvSXHtlh6fSn/2VphU4WRjgFTu6n0rsY7KMLxHGD2+XpU62+G+VUx14H8NR\n" +
                "dF8pxLaXYQqxNpIVJyuWOcfgareTZ/Mo0488Bsvx79a9GjzxmID6AU+5UmwuQB/yyYdPY0rhY8ce\n" +
                "MCSQc4BIFM2+5/OrMoAmlH+2aj44p3MiPyyD1P51II179aMc1KACAaTYDAi4zgV6Z4G48LXQ/wCm\n" +
                "6fzFebhflr0fwNs/4Rq88yeOFBMpMkrYUYIPJpwfvr+uhX2X/XU6MfWqmprM1hIsBcORglPvAd8e\n" +
                "9SG804dNXsW/3ZQf5VGb7T/+gjGf92Nmrp5WZ3Rg+GtIbTrqSbypkVs5aZ8k+wA7ZycnnpXTtOAO\n" +
                "tUH1DTh1vz+Fu9QPqelf8/75/wCuDUmmg0NFbv8A0uAZ/wCWgrmfGs/mauDnpAB+pq5HqWnPdxLH\n" +
                "PM8m7K/LgE1z/iecyaiWP/PMf1qVLoKovduY+nOF1OSY9Vj2g+mT/wDWrp7F+RjPPPXJrlbFAwZz\n" +
                "0Lfy/wD11upceTavMQOeF/xrKo9WzSitEhms37XOoWljCfkEis5HcAiuj+0mPBB47j1rkNJX7SZr\n" +
                "x+SXwo9h/wDXzXQ3LExAjBHqBxXLJdDqi+ptWuoFxuyQR0rThvGyMHn2rj4LjykBJwTWgt22zI49\n" +
                "utZtOL0KumdjDekjBbJHXkcVeS6ViRwfXtXGW2oFR6E8Zz+laMV4QnH6GtY1WtyJQTOmJBGRyvt1\n" +
                "o2gcL+OayItRC4U8n254q9Hfoxwwwcc1vGaZk4tFkqpySPxpSADxnPpQJF/hI+nrT8KFPA575rRE\n" +
                "DMDvgZpyx46c8/pTSVB68joB1/KgOgzwR3OKdxWFEeDkdaQgg5I/HFOEiMRh+vQGplAYfeU/SmhF\n" +
                "bK45XINOAB5AIGcZqdlzng49OlN2EDAx74pgM2jPDYOOgpAhAJ71IEZfpRk5GVz9KYiNQTyf5U/j\n" +
                "+5ml3DccZB796kG3ruHTt3pgR4XcABtYjvTxtHU9eKPL+boRnuKNpz1/OmIcoA9selAHTmkw4A5p\n" +
                "QWbPy8dj6UALsyaUqA+0elJGwI5Gecc1JuVieCPw60wG7eQNlHlDGSKepHGR0p3HPPagRF5K9MUe\n" +
                "QpHr6VKOW5PFKpRX2jn3oC5XWAgYYD6Ypfs69x+lWGOT2OaFz0xz0607BcgFuv507yeRtJ96nJ46\n" +
                "HmhX2scdaLCuMWIY+9z2pj2tvKuJY4pB6MgNTAE884pMNnI/L1pgZ03h3RbgYk0y0OepWIKfzFUJ\n" +
                "vAnh6VsizeM+iSt/U10A3cc9sdKdk8ZB/KlyrsK7OTl+G+hyEtFNeR+gEikfquaozfDCPrDqjL6B\n" +
                "4M/qGrulHPyg89vSn+ZkYweKXJHsPmZ5tJ8NNSXJhvbSTH94sv8AQ1TuPAuvwDK2yTD1jlX+Rwa9\n" +
                "U3exHHrS7z7++TSdKLHzs8abRNVs5v8ASNPuUA/i8skdfXpSsWRwrAqeuCMV7KZSPw9TTZHSVNsi\n" +
                "q656Muan2K6MftDxsSfKfr/SivVZtI0i6bMun2xYc5VdufxHWil7F9x+0R5AI12glsd+R/hTghYE\n" +
                "goSeTg0sB+UKFAU8EkdR/hVtYlkwdx3dB2qTQgjjZsYQEGpvKJ244DdOe1N8qWM42Db3we9Sea7N\n" +
                "IxRjkgjjgVLKQWrHzDk8579verxIAAHAwNuR2qmjwsdwjZHz0YY4qdhlgEY7jyDwTx+NIY8HrjHb\n" +
                "kenenL1A9TgDHb1qJG+YNtLIw4AXIx+tSB0GAcAAYGcjHtSAnjUZOeo460SjFvMmD/q25Az2p0ac\n" +
                "ZDg5PrRIhML5XBKkHjikDPH7gf6RN/vmovSnXQIu5Md2pi/yNBiOBwT61IvSoj1p4PGKTGPJ4Ndf\n" +
                "oMhHhK5wT/x9x/zWuPzweea6jRXx4Tux6XSfzWiOkkPoy+8xPU1WluVRSzMAo6k1C83FZmqRtd23\n" +
                "lqxHOcetdrlYxsWjqtvIpZZDszjftO386ZLcAjg8VhR21yitGJSiMNpA7irkaCKFY1JKqMc1i5Pq\n" +
                "UkaOmyltVt+f4/6VJ4mfF9n/AKZj+ZqrprY1O3/3qd4ofN6P+uY/mazXxjn8AzT0ykaZ5YZ+nek1\n" +
                "28WC28uM9BjFR6JnyZZTLlh8oXOSgx1x6GsjVpvPuNqnKioavOxpF2hc6vRFEeiRjHO3JrWLAxqW\n" +
                "IAHc8CsnTG/4l4QdgKvCTEKlRlsYPNYy3N47COwJ6lQPxqzG/wAgzVQtwGyASOSaktplyc546cUN\n" +
                "aDRYWfa+3GD1471bhvyAF5JHUEEAVmS9ztwSfx/Cow5Q4B/PnHvU8twvY6OHUifvEkDjk4q5Hdlj\n" +
                "kNya5PzwBjH0NWYLtlAIPy+5pcrQXOygvWTjJPbjNaEWo/LyxJ9+1cZDqR6OQAO5rQivo253knp1\n" +
                "4q41GhOKZ16XMcoGSMnnA6mpAQ65Qr689cf0rnoLpTztHyj2I/lV+O4cgMpXPY46fjW8alzJwsaB\n" +
                "TBA4GPbFM2OpGBye/rUUdy+fmIHHzAj+fFTCVCOW2j0zV3RNmPSWYZw2QP1qUXQDBXTqcAjpmmKV\n" +
                "Xn5cUBSytkYJPBI5P1qkSyysiSDIbnHenlCRhWH4VQcP8vl4JPXA/wDr04O64B6+vSqTFYt+XyeP\n" +
                "qaYVOc4z6UwXL59fXNSLcBiQyfnTug1E3MnOcDtnvThJ1GPyp3mJjOCOetBMYB6knrTEKHBxk4Hb\n" +
                "NOKgrgtx2FQBI+pABHIx1FOKqHGGK46+n60xD1XGApwKOeSM81GyEuCkm0HtjOaVd6kneCAPSmBK\n" +
                "JG74yadvBbtntx0qPzCFO7GBQHAO4YP1piJFY9Dg+3pTiygDAx71A2N+5iB6Ub8g8j86AJ/l/wAm\n" +
                "nZAOM/lVYS5AIG4AduaTzwu0sCB3zxmmKxc/GkAzz3FVRMADkHPpTROGQkHJ6fSgLMuLJxtORTgS\n" +
                "O4z61UMihAcYY8dP8aqyanawv5UlzCjEA7Swzj1xQKxrdOcjg0mcDgjisCXxFpsC4a6QkHnbk/yz\n" +
                "UQ8V6czYR5CfTYef5U7BY6TzcHPrTTINxyefWsSPW4J8BVcfhV+CWOYg5kHuMD/GnYCw84UkEVGb\n" +
                "gE4DEVo21haSnLxsxPqxH8q1IdK08Af6LGcf3vm/nUuSQHLG84yGB7cHNIJpXH7tGf2VTXbxWtrH\n" +
                "9y3iU+yAVZBAFLnA4NYL+T5lsrgj3jI/nRXds9FLnEfNQsyp6jI7E9anG9HVNxBIyGIyB7VMeQCw\n" +
                "wp/SmeWnBB+mDWLOknjKzbGIUlxhV700KQgAyVJzgHOTSCORWChsyHkbuMUqRskYwxBBJ29iakYh\n" +
                "DBcsSfqe3c055thj6bmyQSMDFOkJf91s+UqWfK5BHoKQqsrRlQGMgJRd3NAyOK+2E8qHzhT2Ax/n\n" +
                "8q1IfKuAsYdFYcgA+v1rJlgTZlomOTjd1psKEnMZf1GGIz+tIDee18pCVRSw7AcVUg3yqUSN4zkE\n" +
                "YwfwqSK9e3jVS4w/Gxjz+Rq0DHNFlSFBxjb/AE60AeK3ny3cn1qAnhj71a1BSNQlHoarFTgg+tSZ\n" +
                "gxBNOU5FMCjkHOM0/AB46UAKTg/hXTaAPO8O3kXmxxjzlcvI21Rjb3rmOprXs2x4V1IepH81pLdD\n" +
                "WzL8gt0+9qdj/wABl3f0qrLJYr11OI/7qE1ypam1u7szudGZ9MzzfMfpEaQ3ekL/AMvFw30QVzv0\n" +
                "oqeUfMdTYXulvfwpCt0ZSflL4AHHtVTxLcgXozk/IP6/4Vn6Ocavbf739Km8QnOphf70OP1JpJWk\n" +
                "Dd4mPJcNvDRlkI7g4p0N2RIPNG9SeTjmqxorRpMzTa2O206dfKG18owyCK1IZR5Bzt+nSuF0u9+y\n" +
                "zBJDiJj1/un1rsbZwAyFj0yCpHOfSuWpCx1053RYLgoMYz6Hio1YxsOevHcVGjHZgnvzgdaHbDF8\n" +
                "4x0qCy2cgcKW45Ofu1EzY46Y7g9P/r0iupXJyPTFMCl2+Xn0A9aEIkXc2RuIU9QTUo24+UEqOozz\n" +
                "TEBDbQvzDruH8qCA3+16GgB4mcH7zY7KamW5dQDuyOwqpvAGMjHc/wCFKNpyVY7/AE9aLBc0ItQm\n" +
                "R/lfB+uK1LfWXyCQC3c+tc193IOPripA/Az+FLlHzHc2+rqwVdx+mTjNXU1JQobKnPHBNcDBcOjZ\n" +
                "BI9OetacGpsuFJyQe1PmkgsmddHqYVi7/Mc/KR1I9xn+lXF1OHYCDke3b8K5aHVAzDcQAe2KtxXK\n" +
                "7twdsEY69D/WqjVE4HSLdxIFOflb+IDr/hUonjyBnBPIHb/65rGtt8iZSRx6nI4+lTxmVN2XLHHT\n" +
                "jI9+lbqVzNxNXfGwxk8HnNMYhsqCAp7nof8AP1zWUt28VyEkYfOSI3zgr7e4pwnCrLGwC5Ocjv8A\n" +
                "Uevf/JquYXKaqruGARz1OaUsy4CMeO/r7VlJqMEg2yOqTDgAnBYeoNLJfxxqWdsAk84JA/z/AJxV\n" +
                "XFY0ldmcKcggZyecULM3JADen19xWX/bEMaNvkDru5ZOSR6479uf/r1I2rWhTzHfdEvG8A4HrnuK\n" +
                "LisXluwOCrZwejZ/nzQbyJI9zOQOc7hjGOufeqf9o25DFny7c+v5Hj8utRvfaczCOV1UsMDK+x6/\n" +
                "rTuFjSNzE235hk84z/KpVZHyc8r2H+Fc/MlhHbshb90WG2SP+A/09fwqjdyXVsWlilD7AGIyCWXu\n" +
                "cf5707isdZKHJzE4bA+7nH14qBJ5FkdJFUso6DqR64Pv6Vxh1a9eFpIys5HKujDdj8/p+tZdz4t1\n" +
                "G3xl3kh4PlyKDxjrn1B9/WjmCx6LI6MBubaDzu6qD059Peq7XE0WNkvb5RkENXFHxPNMC6zKfMQm\n" +
                "N9o44J2t6/8A16zJPFDxu6H5UTkBTjae+PxxRzBY9IbVkjdN5UKTtyAOD2yO4/8ArU030QDAt86N\n" +
                "nbntnoD1rzNvFxkiYSOd54ytUZ/F96VbMqh92Plz0xS5wsj11tRRdgDOQw3KrnP6/nXjnxFuTL4w\n" +
                "lZGZSkaDryDjP9aYPFmo5KCRnXOQMdOf/wBVY2rvLcSteSpIHdsZb+VDbYnZIW28QavaY8q+kKj+\n" +
                "GT5x+tbVp49u4SBdWFvMO7JlGP8AT9K5ENntTsg1Sk0Qep6Z8RtELAXNvcWxPcAOB/X9K7jSPFfh\n" +
                "++2i31S2LH+F22H8jivnTFAFPnfULH2BZSoyhlYFT0I5BrXicYHNfHNhrWqaYway1C5t8f8APOUq\n" +
                "PyrrdO+LfiuxK77xLlR/DPGDn8Rg0m0wsfUCFgOWB/Cn7q8R0z48J8q6lpBHq9vL/Q/412OnfFvw\n" +
                "nfhQ161q5/hnjI/UZFKwuVncu+KKyoNb0vUE8y01G2mX1SUGiiwrHisXlPCORt3bc56mppIiX/hw\n" +
                "mOOhHp/Oqy7ljGE3EdPanROAryK4LscsMkD6c1mzpJfJc4PXvn/P+FO8uRcgMSSMgjofyxUQnZio\n" +
                "UqjccMOCfyp8jNHKw+YsP9YR0/zzSGSq7YJO0gcHd/SlV90e7aQ/XBGQKYs2AMNjHB3VIXWQ/KwG\n" +
                "30IP4UgFxGV2bAqls4z1Pr+tPRFLZIweg3cEfSoUDIwGM55wc9ani2jgMAQDx7/hQMZMrSNkgMRk\n" +
                "BsH29O/WkjZok2qPlJ3ZBPWkPXaAAyg9OtRq4aNznkNgDHWpYHmeqDGpz+zGqO4Zyavax8uq3K5z\n" +
                "hyP1NZ2QwFIzHDkUvf8AGmb8cYoLcUAOJ6GtS0bPh3Uh9D/L/CskGtvRoFutPvrdnKBwAGAzzSel\n" +
                "hrW5y5o7V06+FocfNdufpGP8alXwzYrjdLcN9CB/Q1rzojkkciqkGnZrsl8P6YvWOZvrL/gKkXR9\n" +
                "MXpZqf8Aedj/AFpe0Q/Zs5bST/xNbb/eqz4gU/2rA2OAgJP0JrpY7S0t2DxWkCMvQ7ckfnWL4kcv\n" +
                "bKSBneAMDHGDSUryuNxsrHKEEUmKlxRWtzLlI63dE1HDx20z7e0bk/8AjprENJSkuZWHFuLud47F\n" +
                "Ny5AYj7uageQ/dzisnTNUFx5dtdN868IxP3vY1reUTnPriuZrldmdKd1dEkc2AMY57GrULKepDEj\n" +
                "ncuMD2rPYFMAt1/WrtvGfJ3HIXqc96TGi2WQpg8KOmahkdOgUrx271BNcAHbxx1GaajMygkgj+VK\n" +
                "w7kwBJ/oeg+vvUqfKuMcnuKiUbhwDt/Un3qZiyjg7SeOaYiNzs6/MPXFCYPLHC9jik2DGGYFR0Ud\n" +
                "6epzkAsF/ummIehLMA23HTdirKqRlQPrz0qJUH8fA/pVlFwCq42gdf5VLGiSIH+8B70+a7W1hMhy\n" +
                "SOeeh+lNHB4CsR/nNYOv3OLYKZCWf5VUD8zUqPMxuVkUf7Xv725NxJcONpOwK20AVrWnie9hx5kr\n" +
                "SAZwWPrWPa27NGFVCasm3njXLOsS+w5rfRGN3udMvieaeI+dEvlnvnn6/nUE2otCbi3M52MMg56A\n" +
                "4IrnyQIG2y5JYA89f84oum+d5C5CkYwT1wAP6VSQcxrXGr71VGJEqAncG74yKda+J5QDHPLlTxlh\n" +
                "1rmGkXzCS45HPamSTLgbATx6UwudbLrEcTAwlQhyRtY/LxjH8qptrM0MoeFztfBYNzniudjluGBU\n" +
                "W/B49KljsL+XBELbT0PNOwXNOTXLlGws2FBymFBwM0L4jlkj8qZsjPVeCP8APP5ms/8AsyReZbuC\n" +
                "L1/eLx+tMNrpUJLTakHPogZj/QU+VibNKLxJd2sj5kZkKFWUnIOelTJ4plG2WNn8xDgDkgqex/z3\n" +
                "rG+3aHCchLmc/QL/AI07/hI7SL/j30hPrLIW/liqSJcjSe/ngvnksxJsdi20ZG3mrN1Pc3xGLch3\n" +
                "5ZQASTxnoPasF/Fl/wD8sYbOD6Qqx/Ns1Wl8T6zKpVtUuFU/wo5UfkKdkHMdLaaBq6wsDFJFE46y\n" +
                "jYo59WwKbJoUcTM95q9lDnkhpg//AKBuri5LyWQkvNK5PXLGoTJntn60/d7E3Z2jxeGYv+PjV3mb\n" +
                "0toCR+pWmf2v4Vtv9Vp17ct/eeRUB/DB/nXG+YaTcfWnzW2Qjsj41t4T/onh+wjYdHkLOfyJx+lZ\n" +
                "mreJb7XIUhuVtkijbcqwwKnPTkgc1z+TU0OMNQ5tgPxjNNNPxxTDUgLkjvTg+ASeaj7UdRQIlMm0\n" +
                "gYOCOKeHU96g5JGT06UZoHctBqcGqpkg8GneYwoC5bWZl+65H0NFVfM9jRTC569HuR9+WAK/e64p\n" +
                "yOp7Aj/ZPb6daxn8QaYjZWbcc5/doy5qJ/FNgu4eVcS9/wDVj+prG6Og3yFdlGACDkZBBoVQWlIb\n" +
                "BkBDGucPjCD5v9Dc5GBucLUB8aSIX2WsSlieWl3YB+gpXQHXhWIRfvCIHfxyRTnjj85sjCbsjGfy\n" +
                "6Vw7eMrsAhEtlBOflV/8ahbxfqLfdnVR/sRA/wA6XMF0dyEwvzEEHow65/DpUybkychgBwAQT+or\n" +
                "ztvE2pMc/bJufQKv8qrPrN7J1ublvrOcflS5h3R6K3m+VIfLPmdOD94e9KrgSoXwikYYswGO/FeY\n" +
                "vfzOPmLN/vMTULTsf4VpXYrou65htcvPK+ZPNbBByMZrOWJ8EYOaU3EgzkgD6CkW4dlDJIce3FGp\n" +
                "Og8W0jc4qRbRiMZFV/NkPV2P403JJ70tR6F4WS/xTxqPcitTSlis7WeWS4h8tmX5g4469fSubJPv\n" +
                "UlrMY5wo5WT5GU9CD/nNHK+rGpLojqm1mwUf8fUZ+hz/ACqFtesR0kY/SNv8KxAi9gKXaOwpXRfK\n" +
                "zVbXrY9Ip2+if40z+3lxiO0m+rED+tZeQenWlAbkkYouHKXX1yc5xaD8ZP8A61Zt9cz3ihZERVB3\n" +
                "fKSTUuD6GmNEcdDTUrCcTNeHHSoylaLQsR0NQSQEHpWimQ4FJgQelNIPpVgoQc00rnmrTM3Egwa6\n" +
                "PSNXEqra3T4k6RyHv7H/ABrAK0zFEkpIE3FncrbsZsycH0x0FJc3eW2IeBwPasKx1pzEtvcvjHCy\n" +
                "9wPQ1orCxbDAH696wcWnqbqV1oSJljkHg+vU1aUgZ3cN2piREDt7mpFIVsZJ+nakBZjwF3EBsfwg\n" +
                "4NNdsPhsnjAOelDSGEbmO58cHuKgXJYnOc+1JDZOuGfCjgdD61ajQ5HAJ7L/AI1FFkgrGMr3FXoI\n" +
                "h1x1689R/hSbBIfGiqNzMWHft/kUuFBO0gIOh7GpGcIefnx1GP5VA7k5Yfd9T3qSivcXcEcnlmVQ\n" +
                "+Purya5jU5JLi/WUKfKQYUVU1SG6tdQmklU7JHLI+cgjtVT+275eEm2joMAZrohC2phKfRm8sl66\n" +
                "AQwuB6gGoHt7nJMsignr5kgB/U1hS6jeTkmSd2z6mq7SO3Vifxq1BEc50LJAg2yX0A9QOf5Co3ud\n" +
                "NUENczOPRUxn9awKTNVZC5mbg1PT4jmK1kc/7b/4CmHXpFz5NrCn1Xd/OsbJoyaYuZmm+t6g3An2\n" +
                "D0T5f5VWkvbiUnzLiRs9ct1qrRQFyQyZ6kn6mk3+gptFADvMam7mPc0lLQAlHalwTTvLbHTH1oEM\n" +
                "pafsA6sKPkHqaBjMUYp+5QeF/M0oZycKPyFADAjHoM1NGpUHPrTSjn7xP/Ajj+dOX5UIyDn07UCJ\n" +
                "OxqM9aUGmnrTASlzSUUCFzRSUUALS0maWgBKKM0UwLglk/vN+dBYv1LGm5OKUMfSuc0Dntmk5p31\n" +
                "pOPSgYoFLwBTaTB96AHhhS5Hoabigk4pDFJ9KbuI6mkpOfSgBcgnmjgDA/QU3FIOKYD8getJuFJn\n" +
                "jvQR70AKSPTNCNiRSAByKbj1oQDzF570AaWMHHrTgOKkMS7up6+lOCJ7/nXO2dKREozx+NOWMHrT\n" +
                "1AHRaUFs/d5+lS2UQsWR8BAR60M7H+HH4VMcntQyd6aJZTbzG7VC6SMOlXiMHNBQH/Gq5rE2uZDQ\n" +
                "v3wKaIip6itKSLPaqrritFO5DjYpuMGoTVyRNw96rMmK2izOSIjWtpWqmFlguGzEeFY/wf8A1qyi\n" +
                "KSm0mrMhNp3O4MnljBGSOmKnizHGJXcdOhrn9D1RPltLtgAB+5kP8J9D7VrzSSOeQMjqBXO4tOx0\n" +
                "Jpq4jO0j56mpFTkAkZqOJWBwflPqe1XYUIGF6Hkep96NgJ7ZSVzwABg+4q+h+XgcH+dQRxgJzwfT\n" +
                "HUVKzmJSMlZe3oRUPUpCyOcFlUsB1yeDVcudxZuV/u4pruWY7mCk9s9ablip3NwvPPpTSE2c14mu\n" +
                "PMaNBwASRXNtweK0tYuTc6i7E/KvyrWa3X8K6oKyOeWrG0CilHSqIDFFLjNLgetAxuKKdxRn2oAb\n" +
                "g0oU0uTRgmgA2+tGAO9Lt55I/Ojj1JoGJx6Uu70A/KlyB0X8zSbj2wPwoAPnPTP4UbCOpA/Ggknq\n" +
                "SabQA7Cjq35CjKg9D+JpMUUALux0AH4UFmPUnFJS0gExUikBMe9MpewpoGPJGOtNpuadmmSFHaly\n" +
                "MCjNACUmeKXFJQIWjNJS96ADNFJRTAsbqNxz3pMj1oyB2rA0H7/UUbs9KYTn+GjJ/uiiwEuaTNN5\n" +
                "9KXJ9aQx27HakLE9jRn60cE9KAEzijNHFN496AHZ560m5e5oIGOlICPT9aAFyO2aXHsaN4xjj86X\n" +
                "ePagYgOVyACPXNCMd4GO/amgBF2pkCrdhF5tyNxOFG7FDskNJtmpk5JCn8qAHznaB+NPJI/hpolb\n" +
                "cBjArmsdQBXzzil2N/e/Sn4J74NIV+U/NzSGN8sMOXNG1V+Xdx2zTTGT3NMZD26+tOwgYAZ5FM8x\n" +
                "FGM1IIt4zxTTCB1x+Ap6E2IWlXPQ1BIQ3QVbaFfeoWiGOAaaaE0zPYnPSoXBJ5q88C4z/Wq0i4OK\n" +
                "2i0ZSRUdCKZVkjPFQspBrVMzaGV0mgX6XOLOcjzgP3Dt3/2TXOUAlWDKSCOQRRJcysEXys9AW3y3\n" +
                "zgcfe3VejVYkLHBb1P8AOsjStU/tKyEjnNxFhZB6+jVae4859ijdXK072Zumty2Ji74XawHHI61H\n" +
                "JOMcdBSqm2LGNhI5PtUbALkqBzTQMaTu5PX+VR3kpjs5HZudhxzTi3f9azNduNmmvjq3y1SV2S3Z\n" +
                "HJPK0jknoWzSN1pvb8aekbyuqRozOeAqjJNdJzjKUdKGUqSGBBHBBpR0oAUUY96SikMXj60Zx2FJ\n" +
                "ilxQAbj9KMmjFGKADvS4opcUAJSUtFABSUtFACUtFGRQAClpM0qsM8igBKDUgxnimSHLnNCBjTRm\n" +
                "kopki5p2aZS5pgPyPxoptFAh1JS54ANJmgBaKKKALG09hRsPoKsCH3pfs/rmsrM0K200BQD1q6Lc\n" +
                "dCBT1hHYUWFco7c+ppfLJ6KaveWDx6d6UJhc45osMpCBvT8zT/s7n0FXVQDjFSBfaiyC5n/ZW4y3\n" +
                "X2p7WOAeSauBcmrPlg/lQBzKg+bIjHO04qQKM9KmuYvK1K4XscEflTAMChjQ3HpTgBSkYNIB1qRi\n" +
                "kDFW9POLk/7h/pVTqDVvT+bse6mplsVHc2ccdKhdM54q1EPkAPbihkFc60OorKWI5696MHkCpNrA\n" +
                "8KSDQEb0pgMXup+tBX6fgKlER4ORkUu0DqTSAgIKHI6HrTCfep2K4xg0RRqQSccdeaV7BuUnPoTU\n" +
                "Dk5rbKIF4QflWfPGVYnb8vanGaYnEzjknkGo5ImPSrzKD2qFlyODzWqkQ4lAw+rUyROOuanlBBx3\n" +
                "pikEc1qn1MrFNlxTCKusi46VWYe4q07kOJNp16+n3izLyuNrr/eU9RXf28UO1J4m+RlDhsZ3LXm1\n" +
                "dZoF802lfZySTbucj/ZPT9c1NSN9R03bQ35pFA4boKriUdVUnuCargyO2djMOw9KnVJGUFiFDL09\n" +
                "aytY0vcc4O4kjBPoa5vxJL+6jj9T/KugdlVMKx6YOa5HXJvNvAoPCj+dXBamc3oZn8I+tXNPvjYz\n" +
                "NIA3zLtypwR+NUz0FLgnAFbNX0MloSXEzXFxJM5JaRixJOeT70wdKTFL2oGLiiiigYUUUUCDrS0m\n" +
                "4DvTd47CgLkgoqPzD24ppYnuaLCuTEgd6aXFRUtOwXHl/QUm402loAXJpaSjmgB1FNBpwpDFAI6U\n" +
                "jfeNLSN940CYlFFJTELRRRQAuaM0lFMB2aKSigQucCikzRQBuKKkC859KUKM08AYrMsQLgDNBXOf\n" +
                "Sn/eA5obuB6UAMxlQFFBXnGak4UADk/zprELn1pDGtgcD6/jThwMZpi9ifype49BQBJF1AzntVo8\n" +
                "fWqsR5HvVhjjr1piMzWk2akj9pIAfxyRVEH0rS1ohvsb99rr+RB/rWWOM1MtykL3oB5pM0daQxw6\n" +
                "VZ05v9Nj4qr2qeybbeRfWplsyo7o6KTCOCBgEU0SL0wSaeG3MBtJA5yamwQemBXNex1WIBuPSM/l\n" +
                "Tgkufu4+pqfaxwQxAHYAc04cjv8AhS5iuUrCBwOWA/Wl8jI5c/hVgKDRt46ijmDlKht09z+NHlhQ\n" +
                "Si4NTsQSVDjI6gdqayFuhpXHYhDHvzUhQOpyKQxcbSevQinJIEG1jyO9S/IZmXEPltjt2NVSuDWt\n" +
                "cGJlKk5z0wKz2jY9q2i7rUyaKbpkZ61C8W0BgMZq00cmcYA+tNMbBcMcj0xWidjNq5UIBHtVSSIq\n" +
                "3AJzVyRNp71DjByOK1izKSKxif0NWdOu5NPu1mA3L0dP7y+lO4ce/cVCy4NVzX0ZNranoEMkckUc\n" +
                "8L/uX5Vxzj2qN5ol5VSRyeecVy2j6ubDfbzAvayHJH90+orog8c0XmwSCSM9x1FZuNmac10QXNwd\n" +
                "vsK465kMtzI5OctWzq95tBjU4Y1gkVpBdTOb6CnnFXtLvzp05lUusmPleM4Zeex7fWqIpatkIdK5\n" +
                "lleTGNzE4puQO9FMbrQJjt4pN59KbRTsK7F3H1pKKKBBRRiimAUUUtIYlLRRigApaMUuKB2AUtGK\n" +
                "XFIdhMUYpwWnBaLjsNGaa3U1MqHIqE9aEJiUUUUyQooooAWiiimAUUUUAFFFFAjotwHTr0pc5NRA\n" +
                "4I60ueMYxWZZOCZGA4AHelZsDauKjBxTGkA4A5J/OgCVmCgc8mkGSSc1CG5zTt2eufpRYLj+59h2\n" +
                "p7FEXk8+npTN8a8kkmoJLrPCggUWC5PFIGfAXAzTLu52yBQx64qrDcDeSOi5/E1SnuN7k07Cua+p\n" +
                "sDYwnPKyH9V/+tWSW4yPWpbi5ae3hQfU/XGKalu7CplZFLUYT8uaUHIq2liSOWFTLp0aDc71nzxL\n" +
                "5WZ2cVLan/S4vrV4HT4yNzMSOwWn/bLDIAjkXnh8A4/ClzX0SKStrc3E5ODT1yBg9RweKrxy5jDZ\n" +
                "5IzxVmACTfnOc+vbFcr0OtO47ORzwKCVUZ7DvUgjA5AFBUnjqDwam5RFvTtyajMg6Y/GmKpGcnJU\n" +
                "7TSHGcVdkTcjnleNhtCkEdcVX+0TH+PA9qsum9cdSOlRBVIz2q1Yl3IssxBLEkepqbdkZHFNPpil\n" +
                "C0mFhjMAaiYg+tSujdBUJV89RQrBYieTHGKgeQ/3astE7dSKYto3fGPc1SaW5LTKErFhjFU33VuN\n" +
                "aA9wPYCq09ooGetXCpHYiUGZKllbIqfAkXI/GpGjVewqI/Kc1re5laxEy4pY55oCTFK6Z67T1qUg\n" +
                "EfWoWGKpO5LRG7vI5d2LMepNMpWYZpuashir0p1NU8UtABTT1NPph6mgTExRil7UYphYKMUcilHN\n" +
                "AxMUU7FGKAsNxS4pcUu2lcLDcUuKdt5qVYR1pXHYhxShCe1Wli9AKmS2ZucCpcylEpCOniL2q8Ld\n" +
                "V6nP0qaOENwFAPqaTkUoFBbct0FSfZiD81aa23IDHk9PSrEdqAegqHMtQMc2+2N25wFJrLNdTfWi\n" +
                "rZTSDghCa5Y1pTd0ZVVZhSdqX1pK0MgooooAKWkooAWkzRRQAUUlFMR//9k=";


        HabitacionDAO.newHabitacion(this,0,"ENERO","05/08/2016-10/08/2016",img5,img5,img5,img5,img5,img5);
        HabitacionDAO.newHabitacion(this,1,"FEBRERO","05/08/2016-10/08/2016",img5,img5,img5,img5,img5,img5);
        HabitacionDAO.newHabitacion(this,2,"MARZO","05/08/2016-10/08/2016",img5,img5,img5,img5,img5,img5);
        HabitacionDAO.newHabitacion(this,3,"ABRIL","05/08/2016-10/08/2016",img5,img5,img5,img5,img5,img5);
        HabitacionDAO.newHabitacion(this,4,"MAYO","05/08/2016-10/08/2016",img5,img5,img5,img5,img5,img5);
        HabitacionDAO.newHabitacion(this,5,"JUNIO","05/08/2016-10/08/2016",img5,img5,img5,img5,img5,img5);
        HabitacionDAO.newHabitacion(this,6,"JULIO","05/08/2016-10/08/2016",img5,img5,img5,img5,img5,img5);
        HabitacionDAO.newHabitacion(this,7,"AGOSTO","05/08/2016-10/08/2016",img5,img5,img5,img5,img5,img5);
        HabitacionDAO.newHabitacion(this,8,"SEPTIEMBRE","05/08/2016-10/08/2016",img5,img5,img5,img5,img5,img5);
        HabitacionDAO.newHabitacion(this,9,"OCTUBRE","05/08/2016-10/08/2016",img5,img5,img5,img5,img5,img5);
        HabitacionDAO.newHabitacion(this,10,"NOVIEMBRE","05/08/2016-10/08/2016",img5,img5,img5,img5,img5,img5);
        HabitacionDAO.newHabitacion(this,11,"DICIEMBRE","05/08/2016-10/08/2016",img5,img5,img5,img5,img5,img5);

        Class fragmentClass = FragmentHotel.class;
        Fragment fragment;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.llInflar, fragment).commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.habitaciones) {
            Class fragmentClass = FragmentHotel.class;
            Fragment fragment;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.llInflar, fragment).commit();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else if (id == R.id.reservar) {
            Class fragmentClass = FragmentReservar.class;
            Fragment fragment;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.llInflar, fragment).commit();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
